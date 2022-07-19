package comp110;

import comp110.engine.BumperGame;
import comp110.engine.CollisionHandler;
import comp110.engine.GameEngine;
import comp110.engine.KeyboardHandler;
import comp110.events.CollisionEvent;
import comp110.events.KeyboardEvent;
import comp110.pieces.Ship;
import comp110.pieces.Puck;
import javafx.scene.paint.Color;
import comp110.events.TimeTickEvent;
import comp110.engine.TimeTickHandler;



public class KeepAway implements BumperGame, KeyboardHandler, CollisionHandler, TimeTickHandler {
	

	  private Ship _homeShip, _awayShip, _possessingShip;
	  private GameEngine _gameEngine;
	  private Puck _puck;
	  
	  
	  public KeepAway() {
		    // TODO: 1.1 Initialize ships.
			_homeShip= new Ship(Color.BLUE, 4.0, 45.0, 30.0, 180.0);
		  	_awayShip= new Ship(Color.GREEN, 4.0, 15.0, 30.0, 0.0);
		  	_puck = new Puck (30.0, 30.0, Color.WHITE);
		  	_possessingShip = null;
		  	_gameEngine = null;
		  }
	
	  public void setup(GameEngine gameEngine) {
		    _gameEngine = gameEngine;

		    // TODO: 1.2 Add pieces to the game engine.
		    _gameEngine.addPiece(_homeShip);
		    _gameEngine.addPiece(_awayShip);
		    _gameEngine.addPiece(_puck);

		  }

		  public Ship getHomeShip() {
		    return _homeShip;
		  }

		  public Ship getAwayShip() {
		    return _awayShip;
		  }

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
	
	public void handleCollision(CollisionEvent collision){

		if ((collision.getB() == _puck && collision.getA() == _homeShip) || (collision.getA() == _puck && collision.getB() == _homeShip)){
//				if (_possessingShip != _homeShip){
//					System.out.println("Blue Ship takes possession");
					_possessingShip = _homeShip;
					_puck.setColor(_possessingShip.getColor());
//				}else{
//					_possessingShip = _awayShip;
//					_puck.setColor(_possessingShip.getColor());
//				}
			}
		if ((collision.getB() == _puck && collision.getA() == _awayShip) || (collision.getA() == _puck && collision.getB() == _awayShip)){
//				if (_possessingShip != _awayShip){
//					System.out.println("Green Ship takes possession");
					_possessingShip = _awayShip;
					_puck.setColor(_possessingShip.getColor());
//				}	else{
//					_possessingShip = _homeShip;
//					_puck.setColor(_possessingShip.getColor());
//				}
			}	
	}
		
	  public void handleTick(TimeTickEvent tick){
		  if (_possessingShip != null){
			  _possessingShip.setScore(_possessingShip.getScore() + tick.getTime());
		  if(_possessingShip.getScore() >= 20.0){
			   _gameEngine.stop();  
			   if (_possessingShip == _awayShip){
				   System.out.println("GreenShip Wins");
			   }
	   			if (_possessingShip == _homeShip){
	   				System.out.println("BlueShip Wins");
		  }
			  }
		   }
	  }

}
