package comp110;

import comp110.support.TextFileReader;

/**
 * Author: Izhan
 *
 * ONYEN:
 *
 * Collaborator(s):
 *
 * UNC Honor Pledge: I certify that no unauthorized assistance has been received
 * or given in the completion of this work. I certify that I understand and
 * could now rewrite on my own, without assistance from collaborators or course
 * staff, the problem set code I am submitting.
 */
public class PaternityTest {

  public static void main(String[] args) {

    // TODO: Part 3.2
	  Sample x = readSample("data/no-spoilers/child.txt");
	  Study y = new Study(x, 25);
	  
	  y.addCandidate(readSample("data/no-spoilers/person0.txt"));
	  y.addCandidate(readSample("data/no-spoilers/person1.txt"));
	  y.addCandidate(readSample("data/no-spoilers/person2.txt"));
	  
	  System.out.println(y.getAncestors());
	  
  }

  // TODO: Part 3.1

  public static Sample readSample(String file){
	  Sample y = new Sample(file);
	  TextFileReader data = new TextFileReader(file);
	  while (data.hasNext()){
		  y.addAllele(data.next());
	  }
	  return y;
  }
}