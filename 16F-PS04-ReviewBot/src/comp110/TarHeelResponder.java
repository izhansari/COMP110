package comp110;

public class TarHeelResponder implements Responder {

	  public boolean canHandle(String message){
		  boolean x = true;
		  if (message.startsWith("t")&&message.endsWith("r")){
			  for (int i = 1; i<message.length()-1; i++){
				  if (message.charAt(i) == 'a'){
					  x = true;
				  }
				  else{
					  return false;
				  }
			  }
			  return x;
		  }
		  return false;
	  }

	  /*
	   * The respondTo method is given a user's message and will return a response
	   * to that message which the bot will then say.
	   */
	  public String respondTo(String message){
		  int i = 0;
		  String e ="E";
		  String yay = "";
		  while(i<message.length()-2){
			  e += "E";
			  yay += "!";
			  i ++;
		  }
		  
		  return "H" + e + "LS" + yay;
	  }
}
