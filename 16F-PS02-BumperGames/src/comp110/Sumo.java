package comp110;

import comp110.engine.BumperGame;
import comp110.engine.GameEngine;
import comp110.engine.KeyboardHandler;
import comp110.events.KeyboardEvent;
import comp110.engine.CollisionHandler;
import comp110.events.CollisionEvent;
import comp110.pieces.Ship;

import javafx.scene.paint.Color;

/**
 * Author: Izhan Ansari	
 *
 * ONYEN: Izhan	
 *
 * Collaborator ONYEN(s): None
 *
 * UNC Honor Pledge: I certify that no unauthorized assistance has been received
 * or given in the completion of this work. I certify that I understand and
 * could now rewrite on my own, without assistance from collaborators or course
 * staff, the problem set code I am submitting.
 */
public class Sumo implements BumperGame, KeyboardHandler, CollisionHandler {

  /*
   * First we're declaring two Ship instance variables.
   */
  private Ship _homeShip, _awayShip;


  /*
   * We're declaring an instance variable to hold a reference to the game
   * engine. We'll need this to stop the game once there is a winner.
   */
  private GameEngine _gameEngine;

  /*
   * Constructor: initialize our instance variables
   */
  public Sumo() {
    // TODO: 1.1 Initialize ships.
	_homeShip= new Ship(Color.BLUE, 4.0, 45.0, 30.0, 180.0);
  	_awayShip= new Ship(Color.GREEN, 4.0, 15.0, 30.0, 0.0);
  }

  /* Methods */

  public void setup(GameEngine gameEngine) {
    _gameEngine = gameEngine;

    // TODO: 1.2 Add pieces to the game engine.
    _gameEngine.addPiece(this.getHomeShip());
    _gameEngine.addPiece(this.getAwayShip());
  }

  public Ship getHomeShip() {
    return _homeShip;
  }

  public Ship getAwayShip() {
    return _awayShip;
  }

  /*
   * TODO: Implement KeyboardHandler and CollisionHandler interfaces.
   */
  
  																						//keyboard handler start
  public void handleKeyPressed(KeyboardEvent event){
	  //System.out.println("Key pressed: " + event.getKey());
	  String key = event.getKey();

	  if (key.equals("UP")) {
		  _homeShip.setThrust(1.0);
	      }
	  else if (key.equals("DOWN")) {
		  _homeShip.setThrust(-1.0);
	  	  } 
	  else if (key.equals("LEFT")) {
	      _homeShip.setTorque(-1.0);
	      }
	  else if (key.equals("RIGHT")) {
	      _homeShip.setTorque(1.0);
	      }
	  else if (key.equals("W")) {
		  _awayShip.setThrust(1.0);
	      }
	  else if (key.equals("S")) {
		  _awayShip.setThrust(-1.0);
	      }
	  else if (key.equals("A")) {
		  _awayShip.setTorque(-1.0);
	      }
	  else if (key.equals("D")) {
		  _awayShip.setTorque(1.0);
	      }
	  else {
		  System.out.println("Error, unrecognized key: " + key);
	  }
	}
  public void handleKeyReleased(KeyboardEvent event){
	 // System.out.println("Key released: " + event.getKey());
	  String key = event.getKey();
	  if (key.equals("UP") || key.equals("DOWN")) {
		  _homeShip.setThrust(0.0);
	      }
	  if (key.equals("LEFT") || key.equals("RIGHT")) {
	      _homeShip.setTorque(0.0);
	      }
	  if (key.equals("W") || key.equals("S")) {
		  _awayShip.setThrust(0.0);
	      }
	  if (key.equals("A") || key.equals("D")) {
		  _awayShip.setTorque(0.0);
	      }
  }
  																							//keyboard handler end
  																							//collision shit start
  public void handleCollision(CollisionEvent collision){
//	if (collision.getA() == _homeShip){
//			System.out.println("Ships Collide");
//	}
//	if (collision.getA() == _gameEngine.getWall()){
//			if (collision.getB() == _homeShip){
//				System.out.println("Blue Ship loses");
//				_awayShip.setScore(1.0);
//				_gameEngine.stop();
//			}
//			else{
//				System.out.println("Green Ship Loses");
//				_homeShip.setScore(1.0);
//				_gameEngine.stop();
//			}

	if ((collision.getA() == _homeShip && collision.getB() == _gameEngine.getWall()) || (collision.getB() == _homeShip && collision.getA() == _gameEngine.getWall())){
		System.out.println("bruh");
		_awayShip.setScore(1.0);
		_gameEngine.stop();
	}
	if ((collision.getA() == _awayShip && collision.getB() == _gameEngine.getWall()) || (collision.getB() == _awayShip && collision.getA() == _gameEngine.getWall())){
		System.out.println("suh");
		_homeShip.setScore(1.0);
		_gameEngine.stop();
	}
	

	  } 
  }

  

  
