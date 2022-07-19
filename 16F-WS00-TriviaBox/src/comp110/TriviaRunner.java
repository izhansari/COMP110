package comp110;

public class TriviaRunner {

  public static void main(String[] args) {

    // TODO: 
    // 1. Declare a variable, named anything you'd like, of type TriviaBox
    // 2. Assign to the variable a new instance of the TriviaBox class
	  TriviaBox d; //declared
	  d = new TriviaBox (); //assigned

    System.out.println("The building you'll find COMP110 office hours in is:");
    // TODO: call your instance's officeHoursBuilding method and print the value returned
    System.out.println(d.officeHoursBuilding());

    
    System.out.println("Number of UNC Football home games:");
    // TODO: call your instance's homeFootballGames method and print the value returned
    System.out.println(d.homeFootballGames());
  
    
    System.out.println("On Thursday, November 10th, Dook's score will be:");
    // TODO: call your instance's dookScore method and print the value returned
    System.out.println(d.dookScore());
    
    
    System.out.println("On Thursday, November 10th, UNC's score will be:");
    // TODO: call your instance's uncScore method and print the value returned  
    System.out.println(d.uncScore());
    
    
    double fahrenheit;
    fahrenheit = 85.0;
    System.out.println(fahrenheit + " degrees fahrenheit converted to celsius is:");
    // TODO: call fahrenheitToCelsius using the fahrenheit variable as input
    System.out.println(d.fahrenheitToCelsius(fahrenheit));
   
  }

}