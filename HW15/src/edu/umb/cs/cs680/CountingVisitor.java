package edu.umb.cs.cs680;

public class CountingVisitor implements FSVisitor {
	
	private int dirNum = 0;
	private int fileNum = 0;
	private int linkNum = 0;

	public CountingVisitor() {}

	@Override
	public void visit(Link link) {
		linkNum++;
	}

	@Override
	public void visit(Directory directory) {
		dirNum++;
	}

	@Override
	public void visit(File file) {
		fileNum++;
	}
	
	public int getDirNum (){
		return this.dirNum;
	}
	
	public int getFileNum (){
		return this.fileNum;
	}
	
	public int getLinkNum (){
		return this.linkNum;
	}

}
