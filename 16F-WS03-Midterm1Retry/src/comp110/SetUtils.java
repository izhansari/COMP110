package comp110;

import java.util.HashSet;
import java.util.Set;

public class SetUtils {

  public static Set<Course> clone(Set<Course> input) {
    // We will make use of HashSet's "copy constructor"
    return new HashSet<Course>(input);
  }

}
