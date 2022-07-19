package comp110.engine;

import comp110.pieces.Ship;
import javafx.scene.paint.Color;

/**
 * By writing a class that implements the Game interface, you are able to add
 * the game created to the GameGUI in the runner. This allows you to write new
 * kinds of games beyond the two we require.
 */
public interface BumperGame {

  public void setup(GameEngine engine);

  public Ship getHomeShip();

  public Ship getAwayShip();

}
