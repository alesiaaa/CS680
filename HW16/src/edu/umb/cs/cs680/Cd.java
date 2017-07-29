package edu.umb.cs.cs680;

public class Cd implements Command{
	
	private FileSystem fs;
	private String path;
	
	private Directory finalDestination;
	private String destinationFolder = null;
	
	Cd (FileSystem fs, String path){
		this.fs = fs; 
		this.path = path;
	}
	
	public void execute() {
		
		if (path.contains("..")){
			//path.matches("cd..") || path.matches("cd ..")
			
			// go back to previous directory
			fs.setCurrent(fs.getCurrent().getParent());
			
		} else if (path.contains("/") || path.matches("cd "+".*[a-zA-Z1-9]+.*")){
			// || path.contains(" ")
			// go to this directory or link of directory
			
			// parse path
			String delims = "[ /]+";
			String[] tokens = path.split(delims);
			
			Directory dir = getDistination(tokens, fs.getCurrent());
			
			if (dir!=null && destinationFolder.equals(dir.getName())){
				fs.setCurrent(dir);
			} else {
				System.out.println("Not a valid directory.");
			}
			
		} else if (path.matches("cd")){
			// go to the root folder
			fs.setCurrent(fs.getRoot());
			
		} else if (path.matches("cd .") || path.matches("cd.")){
			// do nothing
		}
		
	}
	
	
	private Directory getDistination(String[] path, Directory current){
		
		//TODO: Hard to locate bug here when creating a cp of home in dir2 and then navigating to x2
		// The current code does not recognize the original element 
		// Need to add an index marker?
		
		
		Link link = null;
		
		for (int i = 0; i < path.length; i++){
			
		   
			if (!path[i].isEmpty() && !path[i].contains("cd")){
				
				if (i == path.length-1){
					
					//final folder
					//only problem is if it's a link
					destinationFolder = path[i];
				}
				
				
				for (int x = 0; x < current.getChildren().size(); x++){
						
					FSElement currentElement = current.getChildren().get(x);
					
						if (path[i].equals(currentElement.getName()) && currentElement.isLink()){
							// Link
							// Find original element
							
							link = (Link) currentElement;
							
							FSElement originalElement = link.getLinkElement();
							
							if (!originalElement.isFile() && !originalElement.isLink()){
								// original element is a directory
								
								if (i == path.length-1){
									
									// final folder
									// if a link, update the destination folder name
									destinationFolder = originalElement.getName();
								}
								
								
								this.finalDestination = (Directory) originalElement;
								
								path[i] = "";
								
								getDistination(path,this.finalDestination);
								break;
								
							} else {
								// path does not lead to a valid directory or link to directory
								this.finalDestination = null;
							}
							
						} else if (path[i].equals(currentElement.getName()) && !currentElement.isLink()
								&& !currentElement.isFile()){
							// Directory
							current = (Directory) currentElement;
							this.finalDestination = current;
							
						} else if (path[i].equals(currentElement.getName()) && currentElement.isFile()) {
							// File
							// path does not lead to a valid directory
							
							this.finalDestination = null;
							
						} 
						
				} // end of for loop

			path[i] = "";
		
			}
		}
		
		// check that last element in the path was reached
		// if it was not, then return null
		
		return this.finalDestination;
	}
	
	public String toString(){
		return path;
	}


}
