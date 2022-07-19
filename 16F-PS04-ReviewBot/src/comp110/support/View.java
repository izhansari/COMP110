package comp110.support;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import comp110.Controller;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/*
 * The following is support code provided to you. You should not modify any of it until you
 * have submitted for full credit. After you have, if you're curious to tinker around, go for it!
 */
public class View extends Application {

  /* GUI Instance Vars */
  private VBox _chatHistoryContent;
  private ScrollPane _chatHistoryContainer;
  private TextField _messageBox;

  /* Text-to-Speech Instance Var */
  private Voice _voice;

  /* Static Variables (Static needed for JavaFX Launch Workaround Hack) */
  private static Controller _controller;
  private static String _botName, _greeting;

  /* Constants */
  private static final double DEFAULT_WIDTH = 256.0;
  private static final double DEFAULT_HEIGHT = 480.0;
  private static final double MESSAGE_BOX_WIDTH = 256.0;

  /* Constructors */
  public View() {
  }

  public View(String botName, String greeting, Controller controller) {
    _botName = botName;
    _greeting = greeting;
    _controller = controller;
  }

  /* Cutesy hack method to kick-off JavaFX launch process. */
  public void run() {
    Application.launch();
  }

  /* The start Method is where our JavaFX app begins */
  public void start(Stage stage) throws Exception {
    Scene scene = this.initScene();
    this.initStage(stage, scene);
    stage.show();
    this.botSays(_greeting);
  }

  /*
   * Private Methods Begin - Note: if you are a 110er brave enough to read the
   * following code we're breaking a 110 convention here and using private
   * methods. Why? Because these methods are only useful to this specific UI
   * class and we don't really want anyone else using them. Private methods help
   * us clean up a class' code by breaking it down into simpler methods without
   * exposing all of these methods to other classes making use of ChatBotUI.
   * 
   * Notice our getter/setter are public because we *want* other classes to make
   * use of it, however our "internal" methods below are private. In 401 you'll
   * get a lot more exposure to public vs private.
   */

  /*
   * Event handler that is called whenever the user clicks on send or presses
   * enter on the message text box.
   */
  private void handleSendMessage(ActionEvent e) {
    String input = _messageBox.getText();
    _messageBox.clear();
    this.userSays(input);
    String sanitizedInput = this.sanitizeInput(input);
    String response = _controller.dispatch(sanitizedInput);
    if (response != null) {
      this.botSays(response);
    }
  }

  /*
   * This method cleans up a String message by converting it to lower case and
   * removing special characters like commas, periods, quotes, and question
   * marks.
   * 
   * Example:
   * 
   * message: Hi, I'm looking for help with "ADT". Can you help me?
   * 
   * returns: hi im looking for help with adt can you help me
   */
  public String sanitizeInput(String message) {
    String result = message.toLowerCase(); // Convert the message to lowercase.
    result = result.replaceAll("[,.'\"?]", ""); // Remove special characters.
    result = result.trim(); // Remove leading and trailing spaces.
    return result;
  }

  /* Helper methods for sending messages from either bot or user */

  private void botSays(String message) {
    this.speak(message);
    this.addMessageToHistory(_botName, message, false);
  }

  private void userSays(String message) {
    this.addMessageToHistory("You", message, true);
  }

  /*
   * The following methods setup the initial user interface by breaking each
   * step into its own little method.
   */
  private Stage initStage(Stage stage, Scene scene) {
    stage.setTitle("COMP110 - ChatBot");
    stage.setScene(scene);
    return stage;
  }

  private Scene initScene() {
    _chatHistoryContent = this.initChatHistoryContent();
    _chatHistoryContainer = this.initChatHistoryContainer(_chatHistoryContent);

    BorderPane borderPane = new BorderPane();
    borderPane.setCenter(_chatHistoryContainer);
    borderPane.setBottom(this.initTextInputContainer());
    Scene scene = new Scene(borderPane, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    return scene;
  }

  private VBox initChatHistoryContent() {
    VBox chatHistoryUI = new VBox();
    chatHistoryUI.setPrefWidth(256.0);
    chatHistoryUI.heightProperty().addListener(this::handleAutoScroll);
    return chatHistoryUI;
  }

  private ScrollPane initChatHistoryContainer(Node chatHistoryContent) {
    ScrollPane scrollPane = new ScrollPane();
    scrollPane.setContent(chatHistoryContent);
    scrollPane.setFitToHeight(true);
    scrollPane.setFitToWidth(true);
    return scrollPane;
  }

  private HBox initTextInputContainer() {
    HBox textInputContainer = new HBox();
    _messageBox = this.initMessageBox();
    _messageBox.setOnAction(this::handleSendMessage);
    Button sendButton = new Button("Send");
    sendButton.setOnAction(this::handleSendMessage);
    textInputContainer.getChildren().addAll(_messageBox, sendButton);
    Platform.runLater(() -> _messageBox.requestFocus());
    return textInputContainer;
  }

  private TextField initMessageBox() {
    TextField message = new TextField();
    message.setPrefWidth(MESSAGE_BOX_WIDTH);
    return message;
  }

  /* Helper method for adding a new text entry to the chat history UI */

  private void addMessageToHistory(String sender, String message, boolean fromUser) {

    Label userSays = new Label(sender + " said: ");
    VBox.setMargin(userSays, new Insets(15, 25, 0, 25));

    Label messageBox = new Label(message.trim());
    messageBox.setWrapText(true);
    messageBox.setTextAlignment(TextAlignment.LEFT);
    messageBox.setMinHeight(Label.USE_PREF_SIZE);
    if (fromUser) {
      messageBox.setStyle(
          "-fx-font-size: 16px; -fx-background-color: lightgray; -fx-padding: 10px; -fx-background-radius: 10 10 10 10; -fx-font-smoothing-type: lcd;");
    } else {
      messageBox.setStyle(
          "-fx-font-size: 16px; -fx-text-fill: white; -fx-background-color: #99badd; -fx-padding: 10px; -fx-background-radius: 10 10 10 10; -fx-font-smoothing-type: lcd;");
    }
    VBox.setMargin(messageBox, new Insets(0, 25, 5, 25));

    _chatHistoryContent.getChildren().addAll(userSays, messageBox);
  }

  private void handleAutoScroll(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
    _chatHistoryContent.layout();
    _chatHistoryContainer.setVvalue(1.0);
  }

  /* Helper methods for Text-to-Speech */

  private Voice getVoice() {
    if (_voice == null) {
      VoiceManager voiceManager = VoiceManager.getInstance();
      _voice = voiceManager.getVoice("kevin");
      _voice.allocate();
    }
    return _voice;
  }

  private void speak(String text) {
    new Thread(() -> {
      getVoice().speak(text);
    }).start();
  }

}