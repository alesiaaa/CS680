package edu.umb.cs.cs680;

import java.util.ArrayList;

public class Chown implements Command{

	private FileSystem fs;
	private String path;
	
	private ArrayList <String> name = new ArrayList <>();
	private FSElement originalElement = null;
	
	Chown (FileSystem fs, String path){
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
				
				if (!tokens[i].isEmpty() && !tokens[i].equals("chown")){
					//Save in a new list
					name.add(tokens[i]);
				} 
			}
			
			if (name.size() == 2 ){
				
				// Find the original element
				// Look in current directory 
				for (FSElement e : fs.getCurrent().getChildren()){
					
					if (e.getName().equals(name.get(0))){
						this.originalElement = e;
					}
						
				}
				
				if (originalElement == null){
					// If file is not found in current directory
					// Search the system
					this.originalElement = fs.searchFsForElementByName(name.get(0));
				} 
				
				if (this.originalElement == null){
					System.out.println("No element found. Please try again.");
					
				} else {
					// Update owner
					this.originalElement.setOwner(name.get(1));
					
					//Check for update
					checkForUpdate(this.originalElement,name.get(1));
				}
			
			
			} else if (name.size() == 1){
				
				// Update owner
				this.fs.getCurrent().setOwner(name.get(0));
				//Check for update
				checkForUpdate(this.fs.getCurrent(), name.get(0));
				
			} else {
				System.out.println("Input contains more than 3 strings. Please try again.");
			}
			
			
		} else {
			System.out.println("Input contains less than 1 string. Please try again.");
		}
		
	}
	
	public void checkForUpdate(FSElement element, String owner) {
		
		// Check
		if (element.getOwner().equals(owner)){
			System.out.println("Owner updated successfully.");
			//System.out.println("New owner: "+ element.getOwner() +" for " + element.getName());
		} else {
			System.out.println("Something went wrong. Please try again.");
		}
		
	}

	public String toString(){
		return path;
	}

}
