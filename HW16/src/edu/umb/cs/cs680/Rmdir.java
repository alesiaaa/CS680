package edu.umb.cs.cs680;

import java.util.ArrayList;

public class Rmdir implements Command{
	private FileSystem fs;
	private String path;
	private ArrayList <String> name = new ArrayList <>();
	private FSElement element = null;
	
	Rmdir(FileSystem fs, String path){
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
						
						if (!tokens[i].isEmpty() && !tokens[i].equals("rmdir")){
							//Save in a new list
							name.add(tokens[i]);
						} 
					}
					
					if (name.size() == 1 ){
						
						
						for (FSElement e:fs.getCurrent().getChildren()){
							if (e.getName().equals(name.get(0).toString())){
								this.element = e;
							}
						}
						
						//check if directory exists
						if (this.element == null){
							System.out.println("Directory does not exist.");
							
						} else {
							//Remove directory in current folder
							fs.getCurrent().removeChild(this.element);
							
							// Check if directory was removed
							if (!fs.getCurrent().getChildren().contains(this.element)){
								System.out.println("Directory successfully deleted.");
								
							} else {
								System.out.println("Something went wrong. Please try again.");
							}
						}
				
					
					} else {
						System.out.println("Input contains more than 1 string. Please try again.");
					}
					
					
				} else {
					System.out.println("Input contains less than 1 string. Please try again.");
				}
			
	}
	
	public String toString(){
		return path;
	}
}
