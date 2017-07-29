package edu.umb.cs.cs680;

public class Redo implements Command{
	
	private CommandHistory commandHistory;
	
	Redo (CommandHistory commandHistory){
		this.commandHistory = commandHistory; 
		
	}

	@Override
	public void execute() {
		
		// Get last executed command index
		int x = commandHistory.getHistory().size()-1;
		
		// Retrieve command
		Command c = commandHistory.getHistory().get(x);
		
		// Execute redo
		c.execute();
		
		
	}
	
	public String toString(){
		return "redo";
	}	

}
