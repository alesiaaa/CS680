package edu.umb.cs.cs680;

import java.util.ArrayList;
import java.util.Date;

public class Directory extends FSElement {
	
	private ArrayList <FSElement> children;

	public Directory(Directory parent, String name) {
		super(parent, name, 0, new Date());
		children = new ArrayList <FSElement>();
		setLastModified();
	}
	
	
	// Copy constructor
	public Directory(Directory another) {
		super(another.getParent(), another.getName(), another.getSize(), new Date());
		children = new ArrayList <FSElement>();
		children.addAll(another.getChildren());
		setLastModified();
	}

	public ArrayList <FSElement> getChildren() {
		return this.children;
		
	}
	
	public Directory getDirectory(String directory) {
		
		String foundDirectory = null;
		Directory dir = null;
		
		for (int x = 0; x < children.size(); x++){
			
			foundDirectory = children.get(x).getName();
			
			if (foundDirectory == directory){
				
				dir = (Directory) children.get(x);
			}
			
		}
		
		return dir;
	}
	
	public void removeChild (FSElement element) {
		children.remove(element);
		setLastModified();
	}
	
	public void appendChild (FSElement element) {
		children.add(element);
		setLastModified();
	}
	
	public void addChild (FSElement child, int index){
		children.add(index, child);
	}
	
	
	public int getSize () {
		
		int totalSize = 0;
		
		for (FSElement element: children){
		
				totalSize+= element.getSize();
			
		}
		
		return totalSize;
	}
	
	//override toString() method
    @Override 
	public String toString() {
		return getName();
	}
    
    public void accept (FSVisitor v){
		v.visit(this);
		for (FSElement e: children){
			e.accept(v);
		}
	}
    
    public int getDiskUtil(){
    	return 0;
    }

}
