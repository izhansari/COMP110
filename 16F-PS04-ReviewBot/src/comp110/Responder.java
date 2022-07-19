package comp110;

public interface Responder {

  /*
   * The Controller uses this method to ask a Responder if it knows how to
   * respond to a given message.
   */
  public boolean canHandle(String message);

  /*
   * The respondTo method is given a user's message and will return a response
   * to that message which the bot will then say.
   */
  public String respondTo(String message);

}