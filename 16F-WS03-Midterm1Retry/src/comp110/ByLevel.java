package comp110;

public class ByLevel implements Predicate {

  private int _level;

  public ByLevel(int level) {
    _level = level;
  }

  public boolean test(Course c) {
	  int y = c.getNum();
//	  if (((y-_level) < 100 && (y-_level) > 0) || ((_level-y) < 100 && (_level-y) > 0)){
//		  return true;
//	  }
	  int range = _level+100;
	  if (y < range && y >= _level){
		  return true;
	  }
	  
    // TODO: do not always return false. Implement correct logic.
    return false;

  }

}
