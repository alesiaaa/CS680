package edu.umb.cs.cs680;

import java.util.ArrayList;
import java.util.Arrays;

public class Rectangle implements Polygon{
	
	private ArrayList <Point> points = new ArrayList <Point> ();
	
	public Rectangle (Point a, Point b, Point c, Point d){
		
		points.addAll(Arrays.asList(a, b, c, d));
	}
	
	public ArrayList<Point> getPoints(){
		
		return points;
		
	}
	
	
	
	public double getArea(){
		double area = 0;
	
		double [] distance = new double [points.size()]; 
			
		int x = points.size()-1; 
		
		// Calculate distance	
		for (int i = 0; i < points.size(); i++){ 
			 distance[i] = Math.sqrt(
						  ((points.get(x).getX()-points.get(i).getX()) * (points.get(x).getX()-points.get(i).getX())) + 
						  ((points.get(x).getY()-points.get(i).getY()) * (points.get(x).getY()-points.get(i).getY()))
						  );  
			 x = i;  
			    
			 }
			  
				  
		if ((distance[0] == distance[2]) && (distance[1] == distance[3])){
			
			// Calculate area
			return area = distance[0] * distance[1];
			
		} else { 
			
			 System.out.println("Cannot calculate area. Must check coordinates and re-order in clockwise or counter clockwise.");
		}
		
		return area;
	}
	
}
