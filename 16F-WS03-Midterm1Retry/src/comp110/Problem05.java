package comp110;

public class Problem05 {

  public static void main(String[] args) {

    String[] a = new String[] { "A", "B", "C" };
    for (int i = 1; i <= 2; i++) {
      for (String s : a) {
        System.out.println(s + i); // You can only change this line.
      }
    }

  }

}
