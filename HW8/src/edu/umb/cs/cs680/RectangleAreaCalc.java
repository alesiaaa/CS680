package edu.umb.cs.cs680;

import java.util.ArrayList;

public class RectangleAreaCalc implements AreaCalculator{

	@Override
	public float getArea(ArrayList<Point> points, AreaCalculator areaCalc) {
		float area = 0;
		
		float [] distance = new float [points.size()]; 
			
		int x = points.size()-1; 
		
		// Calculate distance	
		for (int i = 0; i < points.size(); i++){ 
			 distance[i] = (float) Math.sqrt(
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
