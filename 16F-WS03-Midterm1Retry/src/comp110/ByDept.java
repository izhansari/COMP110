package comp110;

public class ByDept implements Predicate {

  private String _department;

  public ByDept(String dept) {
    _department = dept;
  }

  public boolean test(Course c) {
    return _department.equals(c.getDepartment());
  }

}
