package edu.umb.cs.cs680;

import java.util.ArrayList;

public class CentroidCalculator {
	
	public Point getCentroid(ArrayList<Point> points){

		
		float xSum = 0;
		float ySum = 0;
		
		for(int i = 0; i < points.size(); i++)
	    {
			xSum += points.get(i).getX();
			
			ySum += points.get(i).getY();
	    }
		
		// Calculate centroid
		float x = xSum/points.size();
		float y = ySum/points.size();
		
		return new Point (x,y);
		
	}

}
