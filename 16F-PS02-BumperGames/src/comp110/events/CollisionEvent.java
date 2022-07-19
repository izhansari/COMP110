package comp110.events;

import comp110.pieces.Piece;
import javafx.event.ActionEvent;

@SuppressWarnings("serial")
public class CollisionEvent extends ActionEvent {

  private Piece _a;
  private Piece _b;

  public CollisionEvent(Piece a, Piece b) {
    super();
    _a = a;
    _b = b;
  }

  public Piece getA() {
    return _a;
  }

  public Piece getB() {
    return _b;
  }

}