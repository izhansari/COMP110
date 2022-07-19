package comp110;

/**
 * Author: Izhan Ansari
 *
 * ONYEN: Izhan
 *
 * Collaborator ONYEN(s):
 *
 * UNC Honor Pledge: I certify that no unauthorized assistance has been received
 * or given in the completion of this work. I certify that I understand and
 * could now rewrite on my own, without assistance from collaborators or course
 * staff, the problem set code I am submitting.
 */

public class TriviaBox {
	public String officeHoursBuilding(){
		 String roomNumber; //declared
		  roomNumber = "Sitterson";  //assigned
		  return roomNumber;
			}
	
	
	public int homeFootballGames(){
		int homeGames; //declared
		homeGames = 7; //assigned
		return homeGames;
	}


	public int dookScore(){
		int badScore; //declared
		badScore = -10; //assigned
		return badScore;
    }
	
	
	public int uncScore(){
		int goodScore; //declared
		goodScore = dookScore() + 110; //assigned
		return goodScore;
	}
	
	
	public double fahrenheitToCelsius(double fahrenheit){
		double celsius; //declared
		celsius = (fahrenheit - 32) * 5 / 9; //assigned
		return celsius;
		
	}

}