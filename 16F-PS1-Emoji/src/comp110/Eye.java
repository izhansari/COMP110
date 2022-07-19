package comp110;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Eye {
	//instance variable
	private Color _irisColor;
	
	//constructor
	public Eye(Color irisColor) {
	    _irisColor = irisColor;
	  }
	
	  public Group shapes(double x, double y) {
		    // Declare a local variable and initialize it to a new Group instance.
		    Group aGroup = new Group();
		    
		    Circle eyeCenter = new Circle();
		    eyeCenter.setRadius(7.0);
		    eyeCenter.setFill(_irisColor);
		    eyeCenter.setCenterX(60.0);
		    eyeCenter.setCenterY(30.0);
		    aGroup.getChildren().add(eyeCenter);
		    
		    // Here is where we move the entire group of shapes based on the
		    // x and y parameters provided to us.
		    aGroup.setTranslateX(x);
		    aGroup.setTranslateY(y);
		  
		    // Finally we return the group to the caller of this method.
		    return aGroup;
}
	// Getter Method
	  public Color getIrisColor() {
	    return _irisColor;
	  }

	  // Setter Method
	  public void setIrisColor(Color irisColor) {
	    _irisColor = irisColor;
	  }
}