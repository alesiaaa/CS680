package edu.umb.cs.cs680;

import java.util.ArrayList;

public class Pwd implements Command{
	
	private FileSystem fs;

	Pwd (FileSystem fs){
		this.fs = fs; 
	}
	
	@Override
	public void execute() {
		
		ArrayList <String> list = new ArrayList<> ();
		
		// Get all parent directories 
		list = fs.getNestedDirectories(fs.getCurrent());
		
		// Get name of current directory 
		String current = fs.getCurrent().getName();
		
		StringBuilder sb = new StringBuilder();
		
		// Create working directory path 
		for (String dir: list){
			sb.append("/" + dir);
		}
		
		sb.append("/" + current);
		
		System.out.println(sb);
		
	}

	public String toString(){
		return "pwd";
	}
	
}
