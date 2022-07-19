package comp110.engine;

import comp110.events.KeyboardEvent;

/**
 * When a Game implements the KeyboardHandler interface, it will receive method
 * calls every time a key is pressed or released on the keyboard. A
 * KeyboardEvent is provided as an argument.
 */
public interface KeyboardHandler {

  public void handleKeyPressed(KeyboardEvent event);

  public void handleKeyReleased(KeyboardEvent event);

}
