package edu.umb.cs.cs680;

import java.util.Objects;

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
	
	//override toString() method
    @Override 
    public String toString(){
        return "(" + getX() + ", " + getY() + ")";
    }
    
    
    //override hashCode() method
    @Override
	public int hashCode (){
		
		return Objects.hash(this.x,this.y);
    }
    
    
    //override equals() method
    @Override
	public boolean equals(Object o){
		
		 // If the object is compared with itself then return true  
        if (o == this) {
            return true;
        } else if (o == null){
        	return false;
        }
        
        Point z = (Point) o;
        
        return Double.compare(x,z.x) == 0 && Double.compare(y,z.y) == 0;
	}
		



}
