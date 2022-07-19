package comp110.pieces;

import org.dyn4j.dynamics.Body;

import javafx.scene.Group;
import javafx.scene.paint.Color;

public interface Piece {

  public final static double RAD_TO_DEG = 57.2958;
  public final static double DEG_TO_RAD = 1 / 57.2958;

  public Body getPhysics();

  public void updateGraphics();

  public Group getGraphics();

  public Color getColor();

  public void setColor(Color color);

}
