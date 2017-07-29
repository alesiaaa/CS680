package edu.umb.cs.cs680;

import java.util.ArrayList;

public class Mv implements Command {

	private FileSystem fs;
	private String path;
	
	private ArrayList <String> name = new ArrayList <>();
	private FSElement destinationElement = null;
	private FSElement originalElement = null;
	
	Mv (FileSystem fs, String path){
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
						
						if (!tokens[i].isEmpty() && !tokens[i].equals("mv")){
							//Save in a new list
							name.add(tokens[i]);
						} 
					}
					
					if (name.size() == 2 ){
						
						// Find the original element
						this.originalElement = fs.searchFsForElementByName(name.get(0).toString());
						
						
						// Find the destination element (directory)
						this.destinationElement = fs.searchFsForElementByName(name.get(1).toString());
						
						
						if (this.originalElement == null) {
						// check for the original element in the file system
							
							System.out.println("Parent element spcified does not exist. Please try again.");
							
						} else if (this.destinationElement == null || this.destinationElement.isFile() ||
								this.destinationElement.isLink()) {
						// check for the destination directory in the file system
							
							System.out.println("Directory spcified does not exist. Please try again.");
							
						} else {
							
							//Find parent directory of element
							Directory originalParent = this.originalElement.getParent();
							
							// Move the file or directory 
							Directory dir = (Directory) destinationElement;
							dir.appendChild(this.originalElement);
							
							// Remove from original directory
							originalParent.removeChild(this.originalElement);
							
							//Update the parent directory in the original element
							this.originalElement.setParent(dir);
							
							if (dir.getChildren().contains(this.originalElement) && 
									!originalParent.getChildren().contains(this.originalElement)){
								System.out.println("Element moved successfully.");
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
