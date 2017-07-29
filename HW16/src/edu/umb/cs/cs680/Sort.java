package edu.umb.cs.cs680;

import java.util.*;

public class Sort implements Command{
	
	private Comparator<FSElement> comparator = null;
	private FileSystem fileSystem;
	private String path;
	private ArrayList <String> name = new ArrayList <>();
	private Directory directory = null;
	
	Sort (FileSystem fileSystem, String path){
		this.fileSystem = fileSystem;
		this.path = path;
	}
	
	@Override
	public void execute() {
		// parse path
		String delims = "[ ]+";
		String[] tokens = path.split(delims);
		
		StringBuilder sb = new StringBuilder();
		
		if (tokens.length > 1){
			
			for (int i = 0; i < tokens.length; i++){
				
				if (!tokens[i].isEmpty() && !tokens[i].equals("sort")){
					//Save in a new list
					name.add(tokens[i]);
				} 
			}
			
			if (name.size() < 3){
				
				
				if (name.get(0).toLowerCase().equals("reverse")){
				
					this.comparator = new ReverseAlphabeticalComparator();
					
					
				} else if (name.get(0).toLowerCase().equals("time")){
					
					this.comparator = new TimeStampComparator();
					
				} else {
					
					System.out.println("Directoy cannot be sorted with this keyword. Please try again.");
					
				}
				
				// need to see if a directory was specified
				if (name.size() > 1){
					// find the specified directory
					directory = (Directory) fileSystem.searchFsForElementByName(name.get(1));
				}
		
			
			} else {
				System.out.println("Input contains more than 3 strings. Please try again.");
			}
			
			
		} else {
			System.out.println("Input contains less than 1 string. Please try again.");
		}
		
		
		if (this.comparator != null && name.size() == 1){
			Collections.sort(fileSystem.getCurrent().getChildren(), this.comparator);
			
			for (FSElement e : fileSystem.getCurrent().getChildren()){
				
				sb.append(e + "\n");
			}
					
			System.out.print(sb);
			
		} else if (this.comparator != null && this.directory != null) {
			
			Collections.sort(directory.getChildren(), this.comparator);
			
			for (FSElement e : directory.getChildren()){
				
				sb.append(e + "\n");
			}
					
			System.out.print(sb);
			
		}
		
	}
	
	public String toString(){
		return path;
	}
	
}
