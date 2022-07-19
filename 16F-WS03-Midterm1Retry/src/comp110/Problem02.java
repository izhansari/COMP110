
package comp110;

public class Problem02 {

  public static void swapNext(char[] a, int i) {
    // TODO:
	  	  char temp  = a[i];
	  	  char temp2 = a[i+1];
	  	  
	  	  a[i]   = temp2;
	  	  a[i+1] = temp;
  }

  public static void main(String[] args) {
    int[] indices = new int[] { 3, 2, 3, 1, 0 };
    char[] a = new char[] { 'a', 'b', 'c', 'd', 'e' };
    for (int i : indices) {
      Problem02.swapNext(a, i);
    }
    // Original question: what are a's element values now?
    // For purposes of this worksheet, we'll print them out:
    for (int i = 0; i < a.length; i++) {
      System.out.println(i + ":" + a[i]);
    }
  }

}
