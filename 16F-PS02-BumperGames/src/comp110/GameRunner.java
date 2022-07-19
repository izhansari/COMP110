package comp110;

import comp110.engine.GameGUI;

public class GameRunner {

  public static void main(String[] args) {

    GameGUI gameGUI = new GameGUI();
    gameGUI.addGameClass(Sumo.class);
    

    // TODO: Uncomment the following line when you're ready to begin KeepAway.
    gameGUI.addGameClass(KeepAway.class);

    // Challenge: Try coming up with your own bumper game and adding it here.

    gameGUI.run();

  }

}
