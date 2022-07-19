package comp110.events;

import javafx.event.ActionEvent;

@SuppressWarnings("serial")
public class TimeTickEvent extends ActionEvent {

  private double _time;

  public TimeTickEvent(double time) {
    _time = time;
  }

  public double getTime() {
    return _time;
  }

}