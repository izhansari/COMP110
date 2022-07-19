package comp110;

public class CourseComparer {

  public void compare(Course a, Course b) {

    if (a.getNum() > b.getNum()) {
      System.out.println("1 a after b");
    } else if (a.getNum() == b.getNum()) {
      System.out.println("0 either way");
    } else {
      System.out.println("-1 a before b");
    }

  }

}
