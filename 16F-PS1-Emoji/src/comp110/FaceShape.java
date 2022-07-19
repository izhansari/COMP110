package comp110;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class FaceShape {

  // Instance Variable
  private Color _tone;

  // Constructor
  public FaceShape(Color tone) {
    // Initialization of instance variables happens in the constructor.
    _tone = tone;
  }

  // Methods

  public Group shapes(double x, double y) {
    // Declare a local variable and initialize it to a new Group instance.
    Group aGroup = new Group();

    // TODO: Draw your FaceShape by adding one or more shapes to aGroup.
    //  * Requirement: One shape in aGroup must have its fill property
    //                 set to the _tone instance variable.
    Circle roundFace = new Circle();
    roundFace.setRadius(50.0);
    roundFace.setFill(_tone);
    roundFace.setCenterX(60.0);
    roundFace.setCenterY(60.0);
    aGroup.getChildren().add(roundFace);
    // Here is where we move the entire group of shapes based on the
    // x and y parameters provided to us.
    aGroup.setTranslateX(x);
    aGroup.setTranslateY(y);
    

    // Finally we return the group to the caller of this method.
    return aGroup;
  }

  // Getter Method
  public Color getTone() {
    return _tone;
  }

  // Setter Method
  public void setTone(Color tone) {
    _tone = tone;
  }

}