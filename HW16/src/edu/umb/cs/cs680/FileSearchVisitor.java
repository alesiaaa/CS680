package edu.umb.cs.cs680;

import java.util.ArrayList;

public class FileSearchVisitor implements FSVisitor {

	private String extension;
	ArrayList <File> foundFiles = new ArrayList<>();
	
	public FileSearchVisitor(String extension) {
		this.extension = extension;
	}

	@Override
	public void visit(Link link) {
		return;
		
	}

	@Override
	public void visit(Directory directory) {
		return;
		
	}

	@Override
	public void visit(File file) {
		if(file.getName().toLowerCase().contains(extension.toLowerCase())){
				foundFiles.add(file); }
		
	}
	
	public ArrayList <File> getFoundFiles(){
		return this.foundFiles;
	}

}
