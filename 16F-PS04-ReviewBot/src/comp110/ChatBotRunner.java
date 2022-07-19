package comp110;

import comp110.support.View;

public class ChatBotRunner {

  public static void main(String[] args) {

    Responder defaultResponder = new DefaultResponder();
    Controller controller = new Controller(defaultResponder);
    SayResponder hey = new SayResponder();
    TarHeelResponder ram = new TarHeelResponder();
    TodoListResponder suh = new TodoListResponder();

    // TODO: Add additional Responders to the controller
    controller.addResponder(hey);
    controller.addResponder(ram);
    controller.addResponder(suh);
    
    // Finally, we give the View the Controller.
    // The view will call the Controller's dispatch method.
    String botName = "ReviewBot";
    String greeting = "Hi, how can I help?";
    View chatBotView = new View(botName, greeting, controller);
    chatBotView.run();

  }

}