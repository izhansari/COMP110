package comp110.pieces;

import org.dyn4j.dynamics.Body;
import org.dyn4j.dynamics.BodyFixture;
import org.dyn4j.geometry.MassType;

import comp110.engine.GameEngine;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;

public class Puck implements Piece {

  private Group _graphics;
  private Body _physics;
  private Color _color;

  public static final Color COLOR = Color.WHITE;

  private static final double RADIUS = 2.0; // m
  private static final double MASS = 0.5; // kg
  private static final double BOUNCINESS = 0.75; // % bounce back
  private static final double FRICTION = 0.1; // resistance against pieces

  private Circle _puck;

  public Puck(double centerX, double centerY, Color color) {
    _color = color;
    this.initPhysics(centerX, centerY);
    this.initGraphics();
    this.updateGraphics();
  }

  public void setColor(Color color) {
    _color = color;
    _puck.setFill(color);
    _puck.setStroke(color.darker());
  }

  public void initPhysics(double centerX, double centerY) {
    Body body = new Body();
    BodyFixture fixture = GameEngine.circle(RADIUS);
    double area = RADIUS * RADIUS;
    double density = MASS / area;
    fixture.setDensity(density);
    fixture.setRestitution(BOUNCINESS);
    fixture.setFriction(FRICTION);
    body.addFixture(fixture);
    body.setMass(MassType.NORMAL);
    body.translate(centerX, centerY);
    _physics = body;
  }

  public void initGraphics() {
    Group graphics = new Group();
    Circle circle = new Circle();
    circle.setRadius(RADIUS);
    circle.setFill(this.getColor());
    circle.setStroke(this.getColor().darker());
    circle.setStrokeWidth(0.3);
    circle.setStrokeType(StrokeType.INSIDE);
    _puck = circle;
    graphics.getChildren().add(circle);
    _graphics = graphics;
  }

  public Body getPhysics() {
    return _physics;
  }

  public void updateGraphics() {
    Body physics = this.getPhysics();
    Group graphics = this.getGraphics();
    graphics.setTranslateX(physics.getTransform().getTranslationX());
    graphics.setTranslateY(physics.getTransform().getTranslationY());
    graphics.setRotate(physics.getTransform().getRotation() * RAD_TO_DEG);
  }

  public Group getGraphics() {
    return _graphics;
  }

  public Color getColor() {
    return _color;
  }

}
