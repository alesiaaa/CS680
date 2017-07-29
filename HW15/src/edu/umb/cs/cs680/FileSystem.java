package edu.umb.cs.cs680;

public class FileSystem {
	
	private static FileSystem instance;
	public Directory root = null;
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
	
	public Directory getRootDirectory(){
		if (this.root == null){
				this.root = new Directory(null, "root");
				this.root.setOwner("osSystem");
			}
		
		return this.root;
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
	
	public static void main (String args[]){
		FileSystem fileSystem = FileSystem.getFileSystem();
		
		fileSystem.getRootDirectory();
		
		Directory system = new Directory(fileSystem.root, "system");
		File a = new File(system, "a.txt", 10);
		File b = new File(system, "b", 10);
		File c = new File(system, "c", 10);
		
		
		Directory home = new Directory(fileSystem.root, "home");
		File d = new File(home, "d.txt", 10);
		Link x = new Link(home, "x");
		x.setElement(system);
		
		Directory pictures = new Directory(home, "pictures");
		File e = new File(pictures, "e", 10);
		File f = new File(pictures, "f", 10);
		Link y = new Link(pictures, "y", e);
		Link x2 = new Link(pictures, "x2", x);
		
		fileSystem.root.appendChild(system);
		fileSystem.root.appendChild(home);
		
		system.appendChild(a);
		system.appendChild(b);
		system.appendChild(c);
		
		pictures.appendChild(e);
		pictures.appendChild(f);
		pictures.appendChild(y);
		pictures.appendChild(x2);
		
		home.appendChild(d);
		home.appendChild(pictures);
		home.appendChild(x);
		
		fileSystem.showAllElements();
	
		
		CountingVisitor visitor = new CountingVisitor();
		fileSystem.root.accept( visitor );
		
		System.out.println("\nNumber of directories: " + visitor.getDirNum());
		System.out.println("Number of files: " + visitor.getFileNum());
		System.out.println("Number of links: " + visitor.getLinkNum());
	
	
		FileSearchVisitor visitor2 = new FileSearchVisitor(".txt");
		fileSystem.root.accept(visitor2);
		visitor2.getFoundFiles().size();
		
		System.out.println("Number of files with .txt: " + visitor2.getFoundFiles().size());
		
		SizeCountingVisitor visitor1 = new SizeCountingVisitor();
		fileSystem.root.accept(visitor1);
		visitor1.getTotalSize();
		System.out.println("Total size: "+ visitor1.getTotalSize());
		
		
	}

}
