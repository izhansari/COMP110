package comp110.engine;

import comp110.events.CollisionEvent;

/**
 * When a Game implements the CollisionHandler interface, it will receive method
 * calls every time two Pieces in the game (Ship, Puck, Wall) collide with one
 * another. A CollisionEvent is provided as an argument.
 */
public interface CollisionHandler {

  public void handleCollision(CollisionEvent collision);

}