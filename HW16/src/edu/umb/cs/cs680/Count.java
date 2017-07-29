package edu.umb.cs.cs680;

import java.util.ArrayList;

public class Count implements Command {
	
	private FileSystem fileSystem;
	private String input;
	private ArrayList <String> name = new ArrayList <>();
	private Directory directory = null;
	private CountingVisitor visitor = null;

	public Count(FileSystem fileSystem, String input) {
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
						
						if (!tokens[i].isEmpty() && !tokens[i].equals("count")){
							//Save in a new list
							name.add(tokens[i]);
						} 
					}
					
					if (name.size() == 1){
						
					// find the specified directory
					directory = (Directory) fileSystem.searchFsForElementByName(name.get(0));
						
						if (directory != null){
							// if found
							
							visitor = new CountingVisitor();
							directory.accept(visitor);
							viewVisitor();
						
						} else {
							System.out.println("Directory was not found. Please try again.");
						}
				
					
					} else if (name.size() == 0){
						// use current
						
						visitor = new CountingVisitor();
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
		StringBuilder sb = new StringBuilder();
		
		sb.append(visitor.getDirNum() + " directories\n");
		sb.append(visitor.getFileNum() + " files\n");
		sb.append(visitor.getLinkNum() + " links\n");
		
		System.out.print(sb);
	}
	
	public String toString(){
		return input;
	}

}
