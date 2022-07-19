package comp110;

import javafx.scene.Group;
import javafx.scene.paint.Color;

/**
 * Author: Izhan Ansari
 *
 * ONYEN: Izhan
 *
 * Collaborator ONYEN(s):
 *
 * UNC Honor Pledge: I certify that no unauthorized assistance has been received
 * or given in the completion of this work. I certify that I understand and
 * could now rewrite on my own, without assistance from collaborators or course
 * staff, the problem set code I am submitting.
 */
public class Emoji {

//ALL instance variables 
	private FaceShape _faceShape;
	private Mouth _mouth;
	private Nose _nose;
	private Eye _leftEye;
	private Eye _rightEye;
	
//constructor. defines what the properties will be when the method is called upon.
		public Emoji (){
			_faceShape = new FaceShape(Color.BLACK);
			_leftEye = new Eye(Color.WHITE);
			_rightEye = new Eye(Color.WHITE);
			_mouth = new Mouth();
			_nose = new Nose();
		}
	
//setters and getters for FACESHAPE
	public FaceShape getFaceShape(){
		return _faceShape;
	}
	public void setFaceShape (FaceShape face){
		_faceShape = face;
	}

//setters and getters for LEFT eye
	public Eye getLeftEye(){
		return _leftEye;
	}
	public void setLeftEye(Eye leftEye){
		_leftEye = leftEye;
	}

//setters and getters for RIGHT eye
	public Eye getRightEye() {
		return _rightEye;
	}
	public void setRightEye(Eye rightEye){
		_rightEye= rightEye;
	}
	
	public Group shapes(double x, double y){
		Group aGroup = new Group();
		
		aGroup.getChildren().add(_faceShape.shapes(10.0, 10.0));
		aGroup.getChildren().add(_mouth.shapes(10.0, 10.0));
		aGroup.getChildren().add(_nose.shapes(10.0, 10.0));
		aGroup.getChildren().add(_leftEye.shapes(10.0, 10.0));
		aGroup.getChildren().add(_rightEye.shapes(10.0, 10.0));
		
	    aGroup.setTranslateX(x);
	    aGroup.setTranslateY(y);
	    
	    return aGroup;
	}
	
}