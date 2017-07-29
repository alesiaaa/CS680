package edu.umb.cs.cs680;

import java.util.ArrayList;

public class Polygon{
	
	private ArrayList<Point> points = new ArrayList<Point>();
	
	private AreaCalculator areaCalc;
	
	private CentroidCalculator centroidCalc = new CentroidCalculator();
	
	Polygon (ArrayList<Point> pts, AreaCalculator areaCalc){
		
		this.points.addAll(pts);
		this.areaCalc = areaCalc;
		
	}
	
	public float getArea(){
		
		return areaCalc.getArea(points, areaCalc);
		
	}
	
	public Point getCentroid(){
		
		return centroidCalc.getCentroid(points);
		
	}
	
	public void addPoint (Point point){
		
		points.add(point);
	}
	
	public void removePoint (Point point){
		
		points.remove(point);
	}
	
	public void setAreaCalc (AreaCalculator areaCalc){
		
		this.areaCalc = areaCalc;
	}
	
	public ArrayList<Point> getPoints(){
		
		return this.points;
		
	}
	
		
}
