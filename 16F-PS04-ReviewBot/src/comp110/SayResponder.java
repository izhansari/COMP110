package comp110;

public class SayResponder implements Responder{
	
	  public boolean canHandle(String x){
		  if (x.startsWith("say")||x.startsWith("Say")||x.startsWith("SAY")){
			  return true;
		  }
			  return false;
	  }
	  public String respondTo(String x){
		  return x.substring(3, x.length());
	  }
		
	
	
}
