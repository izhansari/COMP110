package comp110;

public class Problem04 {

  public static void main(String[] args) {

    int[] a = new int[] { 2, 3, 4, 7, 8 };

    // TODO:
    // For each element in array a, call the foo method
    // with the element as an argument. Print the
    // value returned by foo.
    for (int i : a){
    	System.out.println(foo(i));
    }
    

  }

  public static int foo(int n) {
    while (n > 0) {
      if (n % 2 == 0) {
        return n;
      }
      n--;
    }
    return n;
  }

}
