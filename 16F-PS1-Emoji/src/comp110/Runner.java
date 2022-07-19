package comp110;

import javafx.scene.paint.Color;

public class Runner {

  public static void main(String[] args) {

    // You are ready to begin working on the FaceShape of your emoji!

    // When you start working on Mouth, and other components
    // of your emoji, you'll need to modify the the code below 
    // as described in the Mouth section of the problem set.

    //FaceShape aFaceShape = new FaceShape(Color.LIGHTBLUE);
    //new AutoGUI(aFaceShape.shapes(0.0, 0.0));
    
    
   // Mouth aMouth = new Mouth();
   // new AutoGUI(aMouth.shapes(0.0, 0.0));

   // Nose aNose = new Nose();
   // new AutoGUI(aNose.shapes(0.0, 0.0));

    // Eye leftEye = new Eye(Color.AQUAMARINE);
    // new AutoGUI(leftEye.shapes(0.0, 0.0));

    // Eye rightEye = new Eye(Color.AQUAMARINE);
    // new AutoGUI(rightEye.shapes(0.0, 0.0));
    
	 Emoji rightEye = new Emoji();
	 new AutoGUI(rightEye.shapes(0.0, 0.0));
  }

}