package comp110;

public class Course {

  private String _department;
  private int _number;
  private int _hours;

  public Course(int h, String d, int n) {
    _department = d;
    _number = n;
    _hours = h;
  }

  public String getDepartment() {
    return _department;
  }

  public int getNum() {
    return _number;
  }

  public int getHours() {
    return _hours;
  }

  public String toString() {
    return _department + _number;
  }

}
