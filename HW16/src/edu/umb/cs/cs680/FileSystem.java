package edu.umb.cs.cs680;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FileSystem {
	
	private static FileSystem instance;
	public Directory root = null;
	private Directory current = null;
	private int tab;

	private FileSystem() {}
	
	public static FileSystem getFileSystem(){
		
		clearSystem();
		
		if (instance == null){
			instance = new FileSystem();
			
		}
		return instance;
	}
	
	private static void clearSystem(){
		// Set singleton instance to null
		// to clear out old instance
		// in case one exists
		instance = null;
	}
	
	public Directory getRoot(){
		if (this.root == null){
				this.root = new Directory(null, "root");
				this.root.setOwner("osSystem");
			}
		
		return this.root;
	}
	
	public void setRoot(Directory root){
		if (this.root == null){
			this.root = root;
			this.root.setOwner("osSystem");
		}
		
	}
	
	public void setCurrent (Directory current){
		this.current = current;
	}
	
	public Directory getCurrent(){
		if (this.current == null){
			// set to root by default
			this.current = this.root;
		}
		return this.current;
	}
	
	
	public void addChild(Directory parent, FSElement child){
		parent.addChild(child, getInsertionLocation(parent, child));
	}
	
	public ArrayList<FSElement> getChildren (){
		//default empty to be used with current location in the filesystem
		return this.current.getChildren();
	
	}
	
	public ArrayList<FSElement> getChildren (Directory current){
		//to be used with specified directory
		return current.getChildren();
	
	}
	
	
	public ArrayList<FSElement> sort (ArrayList<FSElement>  list, Comparator<FSElement> comp){

		Collections.sort(list, comp);
		
		return list;
		
	}
	
	
	public int getInsertionLocation(Directory dir, FSElement element){
		ArrayList <FSElement> list  = dir.getChildren();
		
		int location = -1;
		
		if (list.contains(element)){
			location = list.indexOf(element);
		}
		
		return location;
		
	}
	
	public ArrayList<String> getNestedDirectories(Directory directory){
		
		ArrayList<String> list = new ArrayList<> ();
		
		Directory parent = directory.getParent();
		
		while (parent != null) {
		
			// find owner
			String owner = parent.getName();
			// add to list
			list.add(owner);
			
			//find owner as directory
			parent = parent.getParent();
		}
		
		ArrayList<String> list1 = new ArrayList<> ();
		
		for (int x = list.size()-1; x > -1; x--){
			list1.add(list.get(x));
		}
		
		return list1;
		
		
	}
			
	public void showAllElements(){
		
		if (root.getChildren().size() > 0){	
			
			StringBuilder sb = new StringBuilder();
			
			sb.append(root + "\n");
				
				for (FSElement e : root.getChildren()){
					
					sb.append("\t" + e + "\n");
					
					if (!e.isFile() && !e.isLink()){
						
						Directory dir = root.getDirectory(e.getName());
						
						this.tab=2;
						
						for (FSElement a :dir.getChildren()){
							
							sb.append("\t\t" + a + "\n");
							
							// recursive call for more elements
							moreElements(a, this.tab, sb);
							
						}
						
					}
					
				}
			
			System.out.print(sb);
			
		} else {
			System.out.println("Root directory is empty.");
		}
		
	}
	
	
	
	public void moreElements (FSElement a, int num, StringBuilder s){
		
		StringBuilder sb = s;
	
		if (!a.isFile() && !a.isLink()){
			
			Directory dir1 = (Directory) a;
			
			dir1.getDirectory(a.getName());
			
			this.tab++;
			
			for (FSElement b :dir1.getChildren()){
			
				sb.append(getTab() + b + "\n");
				
				moreElements(b, this.tab, sb);
			}
		}
		
	}
	
	public String getTab(){
		
		String tabs = "";
		String tab = "\t";
		
		for(int i=0; i < this.tab; i++){
			
			tabs = tabs + tab;
		}
		
		return tabs;
		
	}
	
	
	public FSElement searchFsForElementByName(String elementName){
		FSElement originalElement = null; 
		
		// search entire file system, DFS
		if (root.getChildren().size() > 0){		
				for (FSElement e : root.getChildren()){
					
					originalElement = DFS (e,elementName, originalElement);
				
				}
			}
		return originalElement;
	}
	
	
	private FSElement DFS (FSElement e, String elementName, FSElement originalElement){
		
		if (elementName.equals(e.getName()) && !e.isLink()){
			originalElement = e;
		
		} else if (!e.isFile() && !e.isLink() && originalElement==null){
			//continue search in directory if element was not found
			
			Directory dir = (Directory) e;
						
			for (FSElement a :dir.getChildren()){
				
				// recursive call for more elements
				originalElement = DFS(a, elementName, originalElement);
				
			}
		}
		
		
		return originalElement;
	}
	
	

}
