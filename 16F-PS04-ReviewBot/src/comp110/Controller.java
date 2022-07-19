package comp110;

import java.util.ArrayList;
import java.util.List;

/*
 * This class is responsible for managing which "mode" the bot is in, as well as
 * dispatching messages to and from that mode.
 */
public class Controller {

  // This instance variable holds all of the bot's Responder implementations.
  private List<Responder> _responders;

  /*
   * The constructor initializes the list of Responders to have the default
   * responder *first* in the List at index 0.
   */
  public Controller(Responder defaultResponder) {
    _responders = new ArrayList<Responder>();
    _responders.add(defaultResponder);
  }

  /*
   * The dispatch method gets called by the View every time a message is
   * received. It is responsible for dispatching a message to a Responder that
   * can respond to the message. It then returns the response back to the View.
   */
  public String dispatch(String message) {
    Responder responder = this.findResponder(message);
    return responder.respondTo(message);
  }

  /*
   * findResponder is given a message and should return the *last* responder in
   * this Controller's _responders which can handle the message.
   */
  public Responder findResponder(String message) {
    // TODO: 2.1 Implement the correct search logic
	  for(int i = _responders.size() - 1 ; i>=0; i-= 1)
		  if(_responders.get(i).canHandle(message)==true){
		  return _responders.get(i);
	  }
//    return _responders.get(_responders.size() - 1);
    return null;
  }

  public void addResponder(Responder responder) {
    _responders.add(responder);
  }

}