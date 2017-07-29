package edu.umb.cs.cs680;

import java.util.ArrayList;

public class Ln implements Command{

	private FileSystem fs;
	private String path;
	private ArrayList <String> name = new ArrayList <>();
	private FSElement element = null;
	private FSElement originalElement = null;

	Ln (FileSystem fs, String path) {
		this.fs = fs; 
		this.path = path;
	}
	
	@Override
	public void execute() {
		// parse path
		String delims = "[ ]+";
		String[] tokens = path.split(delims);
		
	
		if (tokens.length > 1){
			
			for (int i = 0; i < tokens.length; i++){
				
				if (!tokens[i].isEmpty() && !tokens[i].equals("ln")){
					//Save in a new list
					name.add(tokens[i]);
				} 
			}
			
			if (name.size() == 1 ){
				
				// Check current directory to make sure the name is not repeated
				for (FSElement e:fs.getCurrent().getChildren()){
					if (e.getName().equals(name.get(0).toString())){
						this.element = e;
					}
				}
				
				// Find the original element
				this.originalElement = fs.searchFsForElementByName(name.get(0).toString());
				
				// Check if requested link name is availible
				if (this.element != null){
					System.out.println("Name already exists in current directory. Please choose a new name.");
					
				} else if (this.originalElement == null) {
				// check for the original element in the file system
					
					System.out.println("Parent element spcified does not exist. Please try again.");
					
				} else {
					// Create a new link
					Link newLink = new Link(fs.getCurrent(), name.get(0).toString(), this.originalElement);
					
					//Add to parent
					fs.getCurrent().appendChild(newLink);
					
					if (fs.getCurrent().getChildren().contains(newLink)){
						System.out.println("Link successfully created.");
					} else {
						System.out.println("Something went wrong. Please try again.");
					}
				}
		
			
			} else {
				System.out.println("Input contains more than 2 strings. Please try again.");
			}
			
			
		} else {
			System.out.println("Input contains less than 1 string. Please try again.");
		}
		
		
	}
	
	public String toString(){
		return path;
	}

}
