package edu.umb.cs.cs680;

import java.util.ArrayList;

public class FileSearchVisitor implements FSVisitor {

	private String extension;
	ArrayList <File> files = new ArrayList<>();
	
	public FileSearchVisitor(String extension) {
		this.extension = extension;
	}

	@Override
	public void visit(Link link) {
		// Files search does not include links
		return;
	}

	@Override
	public void visit(Directory directory) {
		// Files search does not include directories
		return;
		
	}

	@Override
	public void visit(File file) {
		if(file.getName().toLowerCase().contains(extension.toLowerCase())){
			files.add(file); 
		}
		
	}
	
	public ArrayList <File> getFoundFiles(){
		return this.files;
	}

}
