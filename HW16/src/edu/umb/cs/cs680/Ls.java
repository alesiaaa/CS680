package edu.umb.cs.cs680;

public class Ls implements Command{
	private FileSystem fs;

	Ls (FileSystem fs){
		this.fs = fs;
	}
	
	@Override
	public void execute() {
				
		StringBuilder sb = new StringBuilder();
		
		//sort alphabetically
		fs.sort(fs.getCurrent().getChildren(), new AlphabeticalComparator());
		
		for (FSElement e : fs.getCurrent().getChildren()){
				
			sb.append(e + "\n");
		}
				
		System.out.print(sb);
		
	}
	
	public String toString(){
		return "ls";
	}

}
