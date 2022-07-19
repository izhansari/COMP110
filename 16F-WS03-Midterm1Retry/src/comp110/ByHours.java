package comp110;

public class ByHours implements Predicate {

  private int _hours;

  public ByHours(int hours) {
    _hours = hours;
  }

  public boolean test(Course c) {
    return _hours == c.getHours();
  }

}