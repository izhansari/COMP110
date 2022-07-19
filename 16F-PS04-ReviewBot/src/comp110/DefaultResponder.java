package comp110;

public class DefaultResponder implements Responder {

  public boolean canHandle(String message) {
    return true;
  }

  public String respondTo(String message) {
    return "Oh em gee, I don't know. Teach me with code!";
  }

}
