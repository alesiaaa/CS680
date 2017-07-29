package edu.umb.cs.cs680;

import java.util.ArrayList;

public class Mkdir implements Command{
	private FileSystem fs;
	private String path;
	private ArrayList <String> name = new ArrayList <>();
	private FSElement element = null;
	
	Mkdir(FileSystem fs, String path){
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
				
				if (!tokens[i].isEmpty() && !tokens[i].equals("mkdir")){
					//Save in a new list
					name.add(tokens[i]);
				} 
			}
			
			if (name.size() == 1 ){
				
				
				for (FSElement e: fs.getCurrent().getChildren()){
					if (e.getName().equals(name.get(0).toString())){
						this.element = e;
					}
				}
				
				//check if directory name already exists
				if (this.element != null){
					System.out.println("Name already exists. Please try again.");
					
				} else {
					//Create new directory in current folder
					Directory newDirectory = new Directory(fs.getCurrent(), name.get(0));
					
					//Add to parent
					fs.getCurrent().appendChild(newDirectory);
					
					if (fs.getCurrent().getChildren().contains(newDirectory)){
						System.out.println("Directory successfully created.");
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
