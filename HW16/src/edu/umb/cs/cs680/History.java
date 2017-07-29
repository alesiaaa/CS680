package edu.umb.cs.cs680;



public class History implements Command{
	
	private CommandHistory commandHistory;
	
	History (CommandHistory commandHistory){
		this.commandHistory = commandHistory; 
		
	}

	@Override
	public void execute() {
		
		// Includes all commands, both succefully exceuted and failed
		
		StringBuilder sb = new StringBuilder();
		
		int num = commandHistory.getHistory().size()-1;
		
		// collect history from most recent to least recent
		for(int x = num; x >=0; x--){
			sb.append(commandHistory.getHistory().get(x) + "\n");
			
			//can change this code to use instance of
		}
		
		System.out.print(sb);
		
	}
	
	public String toString(){
		return "history";
	}

}
