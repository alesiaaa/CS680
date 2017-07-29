package edu.umb.cs.cs680;

import java.util.ArrayList;

public class Cp implements Command{
	
	private FileSystem fs;
	private String path;
	
	private ArrayList <String> name = new ArrayList <>();
	private FSElement destinationElement = null;
	private FSElement originalElement = null;
	
	Cp (FileSystem fs, String path){
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
						
						if (!tokens[i].isEmpty() && !tokens[i].equals("cp")){
							//Save in a new list
							name.add(tokens[i]);
						} 
					}
					
					if (name.size() == 2 ){
						
						// Find the original element
						this.originalElement = fs.searchFsForElementByName(name.get(0));
						
						
						// Find the destination element (directory)
						this.destinationElement = fs.searchFsForElementByName(name.get(1));
						
						
						if (this.originalElement == null) {
						// check for the original element in the file system
							
							System.out.println("Parent element spcified does not exist. Please try again.");
							
						} else if (this.destinationElement == null || this.destinationElement.isFile() ||
								this.destinationElement.isLink()) {
						// check for the destination directory in the file system
							
							System.out.println("Directory spcified does not exist. Please try again.");
							
						} else {
							
							// Destination directory
							Directory dir = (Directory) destinationElement;
							
							if (this.originalElement.isFile()){
								//Create a copy of the file
								
								File orig = (File) this.originalElement;
								File copy = new File(orig);
								dir.appendChild(copy);
								
								checkForCopy(dir, copy);
								
							} else if (!this.originalElement.isFile()){
								//Create a copy of the directory
								
								Directory orig = (Directory) this.originalElement;
								Directory copy = new Directory(orig);
								dir.appendChild(copy);
								
								checkForCopy(dir, copy);
							}
				
							
						}
				
					
					} else {
						System.out.println("Input contains more than 2 strings. Please try again.");
					}
					
					
				} else {
					System.out.println("Input contains less than 1 string. Please try again.");
				}
		
	}
	
	public void checkForCopy(Directory dir, FSElement element) {
		
		// Check
		if (dir.getChildren().contains(element)){
			System.out.println("Element copied successfully.");
		} else {
			System.out.println("Something went wrong. Please try again.");
		}
		
	}
	
	public String toString(){
		return path;
	}

}
