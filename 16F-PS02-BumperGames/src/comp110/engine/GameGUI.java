package comp110.engine;

import java.util.ArrayList;

import comp110.events.TimeTickEvent;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GameGUI extends Application {

  private Stage _stage;
  private BumperGame _game;
  private Button _restart;
  private Label _homeScore;
  private Label _awayScore;

  private GameEngine _gameEngine;

  private static Class<? extends BumperGame> _gameClass;
  private static ArrayList<Class<? extends BumperGame>> _gameClasses;

  static {
    _gameClasses = new ArrayList<Class<? extends BumperGame>>();
  }

  public void run() {
    Application.launch();
  }

  public void addGameClass(Class<? extends BumperGame> gameClass) {
    GameGUI._gameClasses.add(gameClass);
    GameGUI._gameClass = gameClass;
  }

  public void start(Stage stage) {
    _stage = stage;
    _stage.setTitle("COMP110 Bumper Games");
    _stage.show();
    this.newGame();
  }

  private void handleRestart(ActionEvent event) {
    this.newGame();
  }

  private void newGame() {
    _gameEngine = new GameEngine();

    try {
      _game = GameGUI._gameClass.getConstructor().newInstance();
    } catch (Exception e) {
      e.printStackTrace();
      System.err.println("Could not construct new instance of " + GameGUI._gameClass.getName());
      System.exit(1);
    }

    _game.setup(_gameEngine);
    _stage.setScene(this.initScene());

    if (_game instanceof CollisionHandler) {
      CollisionHandler collisionAware = (CollisionHandler) _game;
      _gameEngine.setOnCollision(collisionAware::handleCollision);
    }

    _gameEngine.setOnTick(this::handleTick);
    _gameEngine.play();
  }

  private void handleTick(TimeTickEvent event) {
    if (_game instanceof TimeTickHandler) {
      TimeTickHandler tickAware = (TimeTickHandler) _game;
      tickAware.handleTick(event);
    }
    if (_game.getAwayShip() != null) {
      _awayScore.setText(String.format("%.1f", _game.getAwayShip().getScore()));
    }
    if (_game.getHomeShip() != null) {
      _homeScore.setText(String.format("%.1f", _game.getHomeShip().getScore()));
    }
  }

  private Scene initScene() {
    VBox stack = new VBox(8.0);

    Group graphics = _gameEngine.getGraphics();
    stack.getChildren().add(this.initScoreboard(graphics));
    stack.getChildren().add(graphics);

    Scene scene = new Scene(stack);

    scene.setOnKeyPressed(this::handleKeyPressed);
    scene.setOnKeyReleased(this::handleKeyReleased);
    return scene;
  }

  private void handleKeyPressed(KeyEvent keyEvent) {
    if (_game instanceof KeyboardHandler) {
      KeyboardHandler keyboardControllable = (KeyboardHandler) _game;
      keyboardControllable.handleKeyPressed(new comp110.events.KeyboardEvent(keyEvent.getCode().toString()));
    }
    keyEvent.consume();
  }

  private void handleKeyReleased(KeyEvent keyEvent) {
    if (_game instanceof KeyboardHandler) {
      KeyboardHandler keyboardControllable = (KeyboardHandler) _game;
      keyboardControllable.handleKeyReleased(new comp110.events.KeyboardEvent(keyEvent.getCode().toString()));
    }
    keyEvent.consume();
  }

  private Pane initScoreboard(Group graphics) {
    Pane scoreboard = new Pane();

    if (_game.getAwayShip() != null) {
      _awayScore = this.initLabel(_game.getAwayShip().getColor(), 20.0);
      scoreboard.getChildren().add(_awayScore);
    }

    if (_game.getHomeShip() != null) {
      _homeScore = this.initLabel(_game.getHomeShip().getColor(), 400.0);
      scoreboard.getChildren().add(_homeScore);
    }

    HBox hbox = new HBox();

    ChoiceBox<String> gameChoices = new ChoiceBox<String>();
    for (Class<? extends BumperGame> klass : _gameClasses) {
      gameChoices.getItems().add(nameOfClass(klass));
    }
    gameChoices.setValue(nameOfClass(_gameClass));
    gameChoices.setOnAction((e) -> {
      GameGUI._gameClass = GameGUI._gameClasses.get(gameChoices.getItems().indexOf(gameChoices.getValue()));
      this.newGame();
    });
    gameChoices.setFocusTraversable(false);
    hbox.getChildren().add(gameChoices);

    _restart = new Button("Restart");
    _restart.setOnAction(this::handleRestart);
    _restart.setFocusTraversable(false);
    hbox.getChildren().add(_restart);

    hbox.setLayoutX(200.0);
    hbox.setLayoutY(8.0);

    scoreboard.getChildren().add(hbox);

    return scoreboard;
  }

  private String nameOfClass(Class<?> klass) {
    String klassname = klass.getName();
    int lastDotIndex = klassname.lastIndexOf('.');
    klassname = klassname.substring(lastDotIndex + 1);
    return klassname;
  }

  private Label initLabel(Color color, double offsetX) {
    Label label = new Label("0.0");
    label.setTextFill(color);
    label.setFont(new Font("sans", 48.0));
    label.setLayoutX(offsetX);
    return label;
  }

}