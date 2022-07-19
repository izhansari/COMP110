package comp110;

import java.util.HashSet;
import java.util.Set;

public class Utils {

  public static Courses load(String file) {
    // We're going to fake this.
    Set<Course> courses = new HashSet<Course>();
    courses.add(new Course(3, "ECON", 100));
    courses.add(new Course(3, "ECON", 101));
    courses.add(new Course(3, "ECON", 420));
    courses.add(new Course(3, "COMP", 101));
    courses.add(new Course(3, "COMP", 110));
    courses.add(new Course(4, "COMP", 401));
    courses.add(new Course(3, "COMP", 410));
    courses.add(new Course(3, "COMP", 411));
    courses.add(new Course(3, "PSYC", 101));
    courses.add(new Course(7, "PSYC", 270));
    return new Courses(courses);
  }

}
