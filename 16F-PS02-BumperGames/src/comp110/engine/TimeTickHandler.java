package comp110.engine;

import comp110.events.TimeTickEvent;

/**
 * When a Game implements the TimeTickHandler interface, it will receive method
 * calls 60 times per second indicating that some additional time has expired in
 * the game. This can be used to keep track of how long each player has held
 * control of the Puck in KeepAway, for example.
 */
public interface TimeTickHandler {

  public void handleTick(TimeTickEvent tick);

}
