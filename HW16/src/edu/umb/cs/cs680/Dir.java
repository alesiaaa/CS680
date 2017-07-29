package edu.umb.cs.cs680;

import java.util.ArrayList;

public class Dir implements Command{
	
	private FileSystem fs;
	private String path;

	Dir (FileSystem fs, String path) {
		this.fs = fs; 
		this.path = path;
	}

	@Override
	public void execute() {
		StringBuilder sb = new StringBuilder();
		String kind = null;
		
		if (path.matches("dir") || path.matches("dir ") ){
		
			for (FSElement e : fs.getCurrent().getChildren()){
				
				if (e.isFile()){
					kind="File";
				} else if (e.isLink()){
					kind="Link";
				} else if(!e.isFile() && !e.isLink()){
					kind="Directory";
				}
				
				sb.append(e.getName() + " " + kind + " " + e.getSize() + "\n");
			}
				
		} else {
			
			// parse path
			String delims = "[ ./]+";
			String[] tokens = path.split(delims);
			
			ArrayList<FSElement> current = null;
			
			if (path.contains("..")){
				// go to previous directory
				current = fs.getCurrent().getParent().getChildren();
			} else {
				//stay in current directory
				current = fs.getCurrent().getChildren();
			}
			
			for (int i = 1; i < tokens.length; i++){
			
			for (FSElement e : current){
				
				//System.out.println("Token: " + tokens[i]);
				//System.out.println("Current: " + e.getName());
					 
				if (tokens[i].equals(e.getName())){
					
					if (e.isFile()){
						kind="File";
					} else if (e.isLink()){
						kind="Link";
					} else if(!e.isFile() && !e.isLink()){
						kind="Directory";
					}
					
					
					sb.append(e.getName() + " " + kind + " " + e.getSize() + "\n");
					
				}
				
			}
			}
			
						
			
		}
		
		if (!sb.toString().isEmpty()){
			System.out.print(sb);
		} else {
			System.out.println("No such element.");
		}
		
	}
	
	public String toString(){
		return path;
	}

}
