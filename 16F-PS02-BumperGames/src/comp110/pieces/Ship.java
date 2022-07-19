package comp110.pieces;

import static java.lang.Math.abs;
import static java.lang.Math.min;

import org.dyn4j.dynamics.Body;
import org.dyn4j.dynamics.BodyFixture;
import org.dyn4j.geometry.MassType;

import comp110.engine.GameEngine;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeType;

public class Ship implements Piece {

  private Group _graphics;
  private Body _physics;
  private BodyFixture _physicsHull;
  private Color _color;

  private double _score;
  private double _mass;
  private double _bounciness;
  private double _friction;
  private double _startAngle;
  private double _radius;

  // RR: Rear Right
  // RL: Rear Left
  // FR: Front Right
  // FL: Front Left
  private Rectangle _flameFR, _flameRR, _flameFL, _flameRL;

  private Circle _hull;
  private Rectangle _leftEngine, _rightEngine;
  private Arc _window;

  private double _thrust, _torque;

  public Ship(Color color, double radius, double centerX, double centerY, double startAngle) {
    _score = 0.0;
    _thrust = 0.0;
    _torque = 0.0;
    _startAngle = startAngle;
    _radius = radius;
    this.initPhysics(centerX, centerY);
    this.setMass(2.0); // kg
    this.setBounciness(1.0);
    this.setFriction(0.1);
    this.initGraphics();
    this.updateGraphics();
    this.setColor(color);
  }

  public void setScore(double score) {
    _score = score;
  }

  public double getScore() {
    return _score;
  }

  public void setThrust(double thrust) {
    _thrust = thrust;
  }

  public double getThrust() {
    return _thrust;
  }

  public void setTorque(double torque) {
    _torque = torque;
  }

  public double getTorque() {
    return _torque;
  }

  public void setMass(double mass) {
    _mass = mass;
    _physicsHull.setDensity(_mass / (Math.PI * _radius * _radius));
    _physics.setMass(MassType.NORMAL);
  }

  public double getMass() {
    return _mass;
  }

  public void setBounciness(double bounciness) {
    _bounciness = bounciness;
    _physicsHull.setRestitution(_bounciness);
  }

  public double getBounciness() {
    return _bounciness;
  }

  public void setFriction(double friction) {
    _friction = friction;
    _physicsHull.setFriction(friction);
  }

  public double getFriction() {
    return _friction;
  }

  public void initPhysics(double centerX, double centerY) {
    Body body = new Body();
    _physicsHull = GameEngine.circle(_radius);
    body.addFixture(_physicsHull);
    body.rotate(DEG_TO_RAD * _startAngle * -1.0);
    body.translate(centerX, centerY);
    _physics = body;
  }

  /*
   * If we are thrusting or torquing we will conditionally show the flames being
   * emitted from the correct engines.
   */
  public void updateGraphics() {
    Body physics = this.getPhysics();
    Group graphics = this.getGraphics();
    graphics.setTranslateX(physics.getTransform().getTranslationX());
    graphics.setTranslateY(physics.getTransform().getTranslationY());
    graphics.setRotate(physics.getTransform().getRotation() * RAD_TO_DEG);

    if (_thrust > 0.0 || _torque < 0.0) {
      _flameRR.setOpacity(min(1.0, abs(_thrust) + abs(_torque)));
    } else {
      _flameRR.setOpacity(0.0);
    }

    if (_thrust > 0.0 || _torque > 0.0) {
      _flameRL.setOpacity(min(1.0, abs(_thrust) + abs(_torque)));
    } else {
      _flameRL.setOpacity(0.0);
    }

    if (_thrust < 0.0 || _torque > 0.0) {
      _flameFR.setOpacity(min(1.0, abs(_thrust) + abs(_torque)));
    } else {
      _flameFR.setOpacity(0.0);
    }

    if (_thrust < 0.0 || _torque < 0.0) {
      _flameFL.setOpacity(min(1.0, abs(_thrust) + abs(_torque)));
    } else {
      _flameFL.setOpacity(0.0);
    }
  }

  /*
   * The following code is responsible for creating the graphics of a ship. It's
   * broken down into a few different methods not too dissimilar from how we
   * constructed emoji.
   */
  public void initGraphics() {
    Group graphics = new Group();

    _hull = this.initHull(_radius);

    double engineOffset = _radius * 0.7;

    _leftEngine = this.initEngine(_radius);
    _leftEngine.setTranslateY(engineOffset);
    _leftEngine.setTranslateX(_leftEngine.getWidth() / -2.0);

    _rightEngine = this.initEngine(_radius);
    _rightEngine.setTranslateY(-1.0 * engineOffset - _rightEngine.getHeight());
    _rightEngine.setTranslateX(_rightEngine.getWidth() / -2.0);

    double engineWidth = _rightEngine.getWidth();
    double engineHeight = _rightEngine.getHeight();

    _flameRR = this.initFlame(_radius);
    double flameWidth = _flameRR.getWidth();
    double flameHeight = _flameRR.getHeight();
    double flameYOffset = (engineHeight - flameHeight) / 2.0;
    _flameRR.setTranslateX(-1.0 * engineWidth / 2.0 - flameWidth - 0.1);
    _flameRR.setTranslateY(engineOffset + flameYOffset);

    _flameRL = this.initFlame(_radius);
    _flameRL.setTranslateX(-1.0 * engineWidth / 2.0 - flameWidth - 0.1);
    _flameRL.setTranslateY(-1.0 * (engineOffset + engineHeight - flameYOffset));

    _flameFR = this.initFlame(_radius);
    _flameFR.setTranslateX(engineWidth / 2.0 + 0.1);
    _flameFR.setTranslateY(engineOffset + flameYOffset);

    _flameFL = this.initFlame(_radius);
    _flameFL.setTranslateX(engineWidth / 2.0 + 0.1);
    _flameFL.setTranslateY(-1.0 * (engineOffset + engineHeight - flameYOffset));

    _window = this.initWindow(_radius);

    graphics.getChildren().addAll(_hull, _leftEngine, _rightEngine, _flameRR, _flameRL, _flameFR, _flameFL, _window);
    _graphics = graphics;
  }

  private Circle initHull(double radius) {
    Circle circle = new Circle();
    circle.setRadius(radius);
    circle.setStrokeWidth(0.2);
    circle.setStrokeType(StrokeType.INSIDE);
    return circle;
  }

  private Rectangle initEngine(double radius) {
    Rectangle engine = new Rectangle(radius * 1.5, radius * 0.4);
    engine.setArcHeight(engine.getHeight());
    engine.setArcWidth(engine.getHeight());
    return engine;
  }

  private Rectangle initFlame(double radius) {
    Rectangle flame = new Rectangle(radius * 0.6, radius * 0.2);
    flame.setFill(Color.color(0.89, 0.35, 0.13, 1.0));
    flame.setOpacity(0.0);
    flame.setArcHeight(10.0);
    flame.setArcWidth(2.0);
    return flame;
  }

  private Arc initWindow(double radius) {
    double windowRadius = radius * 0.7;
    Arc window = new Arc(0.0, 0.0, windowRadius, windowRadius, -30.0, 60.0);
    window.setType(ArcType.OPEN);
    window.setFill(Color.TRANSPARENT);
    window.setStrokeWidth(0.25 * radius);
    window.setStrokeLineCap(StrokeLineCap.ROUND);
    return window;
  }

  public Body getPhysics() {
    return _physics;
  }

  public Group getGraphics() {
    return _graphics;
  }

  public Color getColor() {
    return _color;
  }

  @Override
  public void setColor(Color color) {
    _color = color;
    Color darker = color.darker();
    Color darkest = darker.darker();
    _hull.setFill(this.getColor());
    _hull.setStroke(darker);
    _leftEngine.setFill(darker);
    _rightEngine.setFill(darker);
    _window.setStroke(darkest);
  }

}