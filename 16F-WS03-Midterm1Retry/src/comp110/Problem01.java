package comp110;

/**
 * Author: Izhan
 *
 * ONYEN: Izhan
 *
 * Collaborator(s): No collaboration is permitted on this work sheet.
 *
 * UNC Honor Pledge: I certify that no unauthorized assistance has been received
 * or given in the completion of this work. I certify that I understand and
 * could now rewrite on my own, without assistance from collaborators or course
 * staff, the problem set code I am submitting.
 */
public class Problem01 {

  public static void main(String[] args) {

    /*
     * Replace ONLY the lines with print statements such that the output matches
     * the output provided on the website write-up.
     */

    for (int i = 5; i > 0; i--) {

      if (i == 6) {
        i = 0;
        System.out.println("A");
      } else if (i == 3) {
        System.out.println("B");
        i = i + 4;
      } else if (i >= 5) {
        System.out.println("C");
      } else {
        System.out.println("D");
      }

      System.out.println(i);


      }
    }

  }


