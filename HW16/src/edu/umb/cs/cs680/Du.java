package edu.umb.cs.cs680;

import java.util.ArrayList;

public class Du implements Command{
	
	private FileSystem fileSystem;
	private String input;
	private ArrayList <String> name = new ArrayList <>();
	private Directory directory = null;
	private SizeCountingVisitor visitor = null;

	public Du(FileSystem fileSystem, String input) {
		this.fileSystem = fileSystem;
		this.input = input;
	}

	@Override
	public void execute() {// parse path
		String delims = "[ ]+";
		String[] tokens = input.split(delims);
			
			if (tokens.length >= 1){
				
				for (int i = 0; i < tokens.length; i++){
					
					if (!tokens[i].isEmpty() && !tokens[i].equals("du")){
						//Save in a new list
						name.add(tokens[i]);
					} 
				}
				
				if (name.size() == 1){
					
				// find the specified directory
				directory = (Directory) fileSystem.searchFsForElementByName(name.get(0));
					
					if (directory != null){
						// if found
						
						visitor = new SizeCountingVisitor();
						directory.accept(visitor);
						viewVisitor();
					
					} else {
						System.out.println("Directory was not found. Please try again.");
					}
			
				
				} else if (name.size() == 0){
					// use current
					
					visitor = new SizeCountingVisitor();
					fileSystem.getCurrent().accept(visitor);
					viewVisitor();
					
				} else {
					
					System.out.println("Input contains more than 2 strings. Please try again.");
				}
				
				
			} else {
				System.out.println("Input contains less than 1 string. Please try again.");
			}
			
	
	}

	private void viewVisitor(){
		
		System.out.print("Total size: " + visitor.getTotalSize() + "\n");
	}

	public String toString(){
		return input;
	}
}
