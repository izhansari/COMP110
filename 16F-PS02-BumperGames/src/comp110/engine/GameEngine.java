package comp110.engine;

import java.util.ArrayList;
import java.util.HashMap;

import org.dyn4j.collision.narrowphase.Penetration;
import org.dyn4j.dynamics.Body;
import org.dyn4j.dynamics.BodyFixture;
import org.dyn4j.dynamics.CollisionAdapter;
import org.dyn4j.dynamics.World;
import org.dyn4j.geometry.Circle;
import org.dyn4j.geometry.Segment;
import org.dyn4j.geometry.Transform;
import org.dyn4j.geometry.Vector2;

import comp110.events.CollisionEvent;
import comp110.events.TimeTickEvent;
import comp110.pieces.Wall;
import comp110.pieces.Piece;
import comp110.pieces.Ship;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class GameEngine extends CollisionAdapter {

  private static final double FRAME_LENGTH = 1.0 / 60.0;

  private World _world;
  private EventHandler<CollisionEvent> _collisionHandler;
  private EventHandler<TimeTickEvent> _tickHandler;

  private ArrayList<Piece> _pieces;
  private HashMap<Body, Piece> _bodyToPieceMap;
  private Wall _wall;

  private Timeline _timeline;
  private boolean _running;
  private double _lastCollision;
  private Group _gameBoard;

  public GameEngine() {
    _bodyToPieceMap = new HashMap<Body, Piece>();
    _pieces = new ArrayList<Piece>();
    _world = this.initWorld();
    _wall = this.initWall();
    this.addPiece(_wall);
    _timeline = this.initTimeline();
    _running = false;
    _lastCollision = 0.0;
  }

  private World initWorld() {
    World world = new World();
    world.setGravity(new Vector2(0.0, 0.0));
    world.addListener(this);
    return world;
  }

  private Wall initWall() {
    return new Wall(0.0, 0.0, Color.BLACK);
  }

  public Wall getWall() {
    return _wall;
  }

  private Timeline initTimeline() {
    Timeline timeline = new Timeline();
    timeline.setCycleCount(Timeline.INDEFINITE);

    KeyFrame interval = new KeyFrame(Duration.seconds(FRAME_LENGTH), this::tick);
    timeline.getKeyFrames().add(interval);

    return timeline;
  }

  public boolean isRunning() {
    return _running;
  }

  public void play() {
    _timeline.play();
    _running = true;
  }

  public void stop() {
    _timeline.stop();
    _running = false;
  }

  public void tick(ActionEvent e) {
    if (_running == false) {
      return;
    }

    _world.update(FRAME_LENGTH);
    _world.setAccumulatedTime(_world.getAccumulatedTime() + FRAME_LENGTH);

    for (Piece piece : _pieces) {
      if (piece instanceof Ship) {

        Ship ship = (Ship) piece;
        double thrust = ship.getThrust();
        double torque = ship.getTorque();
        Transform transform = ship.getPhysics().getTransform();
        double rotation = transform.getRotation();

        Vector2 thrustV;
        if (thrust != 0.0) {
          thrustV = new Vector2(rotation).product(thrust * 100.0);
        } else {
          // Slow down the ship if not thrusting
          thrustV = ship.getPhysics().getLinearVelocity().product(-5.0);
        }
        ship.getPhysics().applyForce(thrustV);

        if (torque == 0.0) {
          // Slow down the spin if not torquing
          torque = ship.getPhysics().getAngularVelocity() * -0.5;
        }

        ship.getPhysics().applyTorque(torque * 100.0);
      }
      piece.updateGraphics();
    }

    if (_tickHandler != null) {
      _tickHandler.handle(new TimeTickEvent(FRAME_LENGTH));
    }
  }

  public void setOnTick(EventHandler<TimeTickEvent> handler) {
    _tickHandler = handler;
  }

  public void addPiece(Piece piece) {
    Body body = piece.getPhysics();
    _world.addBody(body);
    _bodyToPieceMap.put(body, piece);
    _pieces.add(piece);
    piece.updateGraphics();
  }

  public void removePiece(Piece piece) {
    Body body = piece.getPhysics();
    _world.removeBody(piece.getPhysics());
    _bodyToPieceMap.remove(body);
    _pieces.remove(piece);
    _gameBoard.getChildren().remove(piece.getGraphics());
  }

  public boolean collision(Body bodyA, BodyFixture fixtureA, Body bodyB, BodyFixture fixtureB,
      Penetration penetration) {
    if (_collisionHandler != null) {
      Piece a = _bodyToPieceMap.get(bodyA);
      Piece b = _bodyToPieceMap.get(bodyB);

      if (a instanceof Ship && b instanceof Ship) {
        double time = _world.getAccumulatedTime();
        if (time - _lastCollision < .5) {
          // Filter collisions that occur within one tenth of a second of another
          return true;
        }
        _lastCollision = time;
      }

      CollisionEvent event = new CollisionEvent(a, b);
      _collisionHandler.handle(event);
    }
    return true;
  }

  public void setOnCollision(EventHandler<CollisionEvent> handler) {
    _collisionHandler = handler;
  }

  public Group getGraphics() {
    Group container = new Group();

    _gameBoard = new Group();
    for (Piece piece : _pieces) {
      _gameBoard.getChildren().add(piece.getGraphics());
    }
    Bounds bounds = _gameBoard.getChildren().get(0).getLayoutBounds();
    _gameBoard.setTranslateX(bounds.getWidth() * 3.5);
    _gameBoard.setTranslateY(bounds.getHeight() * 3.5);
    _gameBoard.setScaleX(8.0);
    _gameBoard.setScaleY(8.0);
    container.getChildren().add(_gameBoard);

    return container;
  }

  /* Static Utility Methods */

  public static Segment segment(double x1, double y1, double x2, double y2) {
    return new Segment(new Vector2(x1, y1), new Vector2(x2, y2));
  }

  public static BodyFixture circle(double radius) {
    Circle circle = new Circle(radius);
    BodyFixture fixture = new BodyFixture(circle);
    return fixture;
  }

}