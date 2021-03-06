package HW2;

public class Point {
	
	private double x;
	private double y;
	
	// constructor
	public Point (double x, double y){
		
		this.x = x;
		this.y = y;
	}
	
	public double getX (){
		return x;
	}
	
	public double getY (){
		return y;
	}
	
	//overriding toString() method
    @Override 
    public String toString(){
        return "(" + getX() + ", " + getY() + ")";
    }

}
