package comp110;

import java.util.List;
import java.util.ArrayList;


public class TodoListResponder implements Responder{

	private List<String> _todos;
	public TodoListResponder(){
		_todos = new ArrayList<String>();
	}
	
	  public boolean canHandle(String message){
		  if (message.startsWith("todo")|| message.startsWith("TODO")){
			  return true;
		  }
		  else{
			  return false;
		  }
	  }
	  public String respondTo (String message){
		  String[] args = message.split(" ");
		  
		  if (args.length<=1){
			  return "invalid Usage: todo add <item>";
		  }
		  
		  String command = args[1];
		  String sent = "";
		  if (command.equals("add")){
			  if (args.length > 2){
				  for (int i = 2; i< args.length; i++){
					  sent += args[i] + " ";
				  }
				 _todos.add(sent);
				 return "Got it!";
			  }
			  else {
				  return "usage: invalid";
			  }
		  }
		  
		  if (command.equals("list")){
			  if (_todos.isEmpty()){
				  return "You have nothing to do.";
			  } else{
				  String x = "You have to: \n";
				  for (int i = 0 ; i < _todos.size(); i++){
					  x += i + ": " + _todos.get(i) + "\n";
				  }
				  return x;
			  }
		  }
		  
		  if (command.equals("next")){
			  if (_todos.size()==0){
				  return "Relax. Your work is done here.";
			  }
			  else {
				  return _todos.get(0);
			  }
		  }
		  
		  if (command.equals("done")){
			  if (_todos.size()==0){
				  return "But you had nothing to do!";
			  }
			  else{
				  _todos.remove(0);
				  return "Great work!";
			  }
		  }
		  
		  if (command.equals("swap")){
			  int first = Integer.parseInt(args[2]);
			  int second = Integer.parseInt(args[3]);

			  
			  if (args.length== 2){
				  return "Usage: todo swap <index> <index>";
			  }
			  
			  else if (args.length==3) {
				  return "Usage: todo swap <" + first + "> <index>";
			  }
			  
			  else if (args.length == 4){
				  if(first > _todos.size() - 1 || second > _todos.size()-1){
					  return "Hahaha you can't trick me!";
				  }
				  String y= _todos.get(second);
				  String z= _todos.get(first);
				  _todos.set(first, y);
				  _todos.set(second, z);
				  return "No problem!";
			  }
			  else if(args.length>4){
				  return "Usage: todo swap <index> <index>";
			  }
			  return "Invalid Command";
		  }
	  
		  return message;
	  }
}
