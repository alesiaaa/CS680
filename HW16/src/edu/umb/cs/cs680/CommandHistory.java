package edu.umb.cs.cs680;

import java.util.LinkedList;

public class CommandHistory {
	
	private LinkedList<Command> history = null;
	
	public CommandHistory(){
		history = new LinkedList<> ();
	}
	
	public void push (Command newCommand){
		history.add(newCommand);
	}
	
	public Command pop(){
		
		Command oldest = history.getFirst();
		
		// check that list is not empty
		if(oldest != null){
			// remove oldest command
			history.remove(oldest);	
		}
	
		return oldest;
		 
	}
	
	public LinkedList<Command> getHistory(){
		return this.history;
	}
	
	

}
