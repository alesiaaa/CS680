package edu.umb.cs.cs680;

import java.util.ArrayList;

public class Search implements Command {
	private FileSystem fileSystem;
	private String input;
	private ArrayList <String> name = new ArrayList <>();
	private FileSearchVisitor visitor = null;

	public Search(FileSystem fileSystem, String input) {
		this.fileSystem = fileSystem;
		this.input = input;
	}

	@Override
	public void execute() {
		// parse path
			String delims = "[ ]+";
			String[] tokens = input.split(delims);
				
				if (tokens.length >= 1){
					
					for (int i = 0; i < tokens.length; i++){
						
						if (!tokens[i].isEmpty() && !tokens[i].equals("search")){
							//Save in a new list
							name.add(tokens[i]);
						} 
					}
					
					if (name.size() == 1){
						
					
						visitor = new FileSearchVisitor(name.get(0));
						fileSystem.getCurrent().accept(visitor);
						viewVisitor();
							
					} else if (name.size() == 0){
						
						System.out.println("Nothing to search. Please try again.");
						
					} else {
						
						System.out.println("Input contains more than 1 search string. Please try again.");
					}
					
					
				} else {
					System.out.println("Input contains less than 1 string. Please try again.");
				}
				
		
	}
	
	private void viewVisitor(){
			
		System.out.print("Found files: " + visitor.getFoundFiles().size() + "\n");
		
	}
	
	public String toString(){
		return input;
	}

}
