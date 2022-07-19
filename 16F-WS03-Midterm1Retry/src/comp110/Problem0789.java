package comp110;

public class Problem0789 {

  public static void main(String[] args) {

    // PROBLEM 7.
    System.out.println("PROBLEM 7");
    // Dept   Num   Hours
    // COMP   401   4
    // COMP   410   3
    // ECON   410   3

    Course comp401, comp410, econ410;

    comp401 = new Course(4, "COMP", 401); // TODO: Construct a Course instance
    System.out.println(comp401);

    comp410 = new Course(3, "COMP", 410); // TODO: Construct a Course instance
    System.out.println(comp410);

    econ410 = new Course(3, "ECON", 410); // TODO: Construct a Course instance
    System.out.println(econ410);

    // PROBLEM 8
    System.out.println("PROBLEM 8");
    CourseComparer c = new CourseComparer();

    // TODO: Perform method calls on CourseComparer c
    // that would result in the following Expected Output:
    // 
    // Expected Output:
    // -1 a before b
    // 1 a after b
    // 0 either way
    
    c.compare(comp401, comp410);

    c.compare(comp410, comp401);
    
    c.compare(econ410, comp410);

    // Perform those method calls here. Run to check output.

    // PROBLEM 9
    System.out.println("PROBLEM 9");
    Predicate p1 = new ByHours(3);
    System.out.println(p1.test(comp401)); // TODO: call test on p1 with comp401
    System.out.println(p1.test(comp410)); // TODO: call test on p1 with comp410
    System.out.println(p1.test(econ410)); // TODO: call test on p1 with econ410

    Predicate p2 = new ByDept("COMP");
    System.out.println(p2.test(comp401)); // TODO: call test on p2 with comp401
    System.out.println(p2.test(comp410)); // TODO: call test on p2 with comp410
    System.out.println(p2.test(econ410)); // TODO: call test on p2 with econ410

  }

}
