package comp110.events;

import javafx.event.ActionEvent;

@SuppressWarnings("serial")
public class KeyboardEvent extends ActionEvent {

  private String _key;

  public KeyboardEvent(String key) {
    _key = key;
  }

  public String getKey() {
    return _key;
  }

}
