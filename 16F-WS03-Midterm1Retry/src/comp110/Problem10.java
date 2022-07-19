package comp110;

public class Problem10 {

  public static void main(String[] args) {

    // For this Problem you must implement the test method
    // of the ByLevel class. 

    // !!!!! Do your work in ByLevel.java and check it by 
    // running this file.

    boolean b;

    Predicate p3 = new ByLevel(400);
    b = p3.test(new Course(3, "COMP", 401));
    System.out.println("Expected: true - Actual: " + b);
    b = p3.test(new Course(3, "COMP", 410));
    System.out.println("Expected: true - Actual: " + b);

    Predicate p4 = new ByLevel(300);
    b = p4.test(new Course(3, "COMP", 401));
    System.out.println("Expected: false - Actual: " + b);
    b = p4.test(new Course(3, "COMP", 410));
    System.out.println("Expected: false - Actual: " + b);
    
    double x =0.99;
    double y = 1;
    System.out.println(x/y);

  }

}
