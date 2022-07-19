package comp110;

import java.util.HashSet;
import java.util.Set;

public class Courses {

  private Set<Course> _courses;

  public Courses(Set<Course> courses) {
    _courses = courses;
  }

  public Set<Course> getCourses() {
    return _courses;
  }

  public Courses union(Courses other) {
    Set<Course> set = SetUtils.clone(_courses);
    set.addAll(other.getCourses());
    return new Courses(set);
  }

  public Courses intersect(Courses other) {
    Set<Course> set = SetUtils.clone(_courses);
    set.retainAll(other.getCourses());
    return new Courses(set);
  }

  public Courses subtract(Courses other) {
    Set<Course> set = SetUtils.clone(_courses);
    set.removeAll(other.getCourses());
    return new Courses(set);
  }

  public Courses filter(Predicate p) {
    Set<Course> set = new HashSet<Course>();
    
    for (Course c: _courses){
    	if (p.test(c) == true){
    		set.add(c);
    	}
    }
    // TODO: Problem 11 Solution Goes Here.

    return new Courses(set);
  }

  public String toString() {
    return _courses.toString();
  }

}
