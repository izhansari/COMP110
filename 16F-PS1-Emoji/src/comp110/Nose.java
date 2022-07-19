package comp110;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Nose {
	  public Group shapes(double x, double y) {
		    Group aGroup = new Group();

		    Circle roundNose = new Circle();
		    roundNose.setRadius(10.0);
		    roundNose.setFill(Color.BROWN);
		    roundNose.setCenterX(60.0);
		    roundNose.setCenterY(60.0);
		    aGroup.getChildren().add(roundNose);

		    aGroup.setTranslateX(x);
		    aGroup.setTranslateY(y);
		    

		    // Finally we return the group to the caller of this method.
		    return aGroup;

}}