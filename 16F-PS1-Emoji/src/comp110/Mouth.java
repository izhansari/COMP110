package comp110;


import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Mouth {
	  public Group shapes(double x, double y) {
		    // Declare a local variable and initialize it to a new Group instance.
		    Group aGroup = new Group();
		    
		    Rectangle roundMouth = new Rectangle();
		    roundMouth.setHeight(40.0);	
		    roundMouth.setWidth(20.0);
		    roundMouth.setFill(Color.AQUA);
		    aGroup.getChildren().add(roundMouth);
		    
		    // Here is where we move the entire group of shapes based on the
		    // x and y parameters provided to us.
		    aGroup.setTranslateX(x);
		    aGroup.setTranslateY(y);
		    

		    // Finally we return the group to the caller of this method.
		    return aGroup;
		  }

}