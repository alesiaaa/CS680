package edu.umb.cs.cs680;

import java.util.ArrayList;

public class TriangleAreaCalc implements AreaCalculator{

	@Override
	public float getArea(ArrayList<Point> points, AreaCalculator areaCalc) {
		float area = 0;
		
		// Calculate distance
		
		float a = (float) Math.sqrt( Math.pow((points.get(1).getX() - points.get(0).getX()),2) + Math.pow((points.get(1).getY() - points.get(0).getY()),2));
		
		float b = (float) Math.sqrt( Math.pow((points.get(2).getX() - points.get(1).getX()),2) + Math.pow((points.get(2).getY() - points.get(1).getY()),2));
		
		float c = (float) Math.sqrt( Math.pow((points.get(0).getX() - points.get(2).getX()),2) + Math.pow((points.get(0).getY() - points.get(2).getY()),2));
		
		
		// Heron's formula for triangle area
		
		float s = (float) 0.5*(a+b+c);
		
		area = (float) Math.sqrt(s*(s-a)*(s-b)*(s-c));
		
		return area;
	}
	
	
	
	public static void main(String args[]){

		ArrayList<Point> al = new ArrayList<Point>();
		al.add( new Point(0, 0) ); 
		al.add( new Point(3, 0) ); 
		al.add( new Point(3, 3) );
		Polygon p = new Polygon( al, new TriangleAreaCalc() );
		
		System.out.println("Triangle");
		System.out.println("Points: "+ p.getPoints());
		System.out.println("Area: "+ p.getArea());
		System.out.println("Centroid: " + p.getCentroid());
		
		p.addPoint( new Point(0, 3) );
		p.setAreaCalc( new RectangleAreaCalc() );
		
		System.out.println("\nRectangle");
		System.out.println("Points: "+ p.getPoints());
		System.out.println("Area: "+ p.getArea());
		System.out.println("Centroid: " + p.getCentroid());
		
		p.removePoint( new Point(0, 0) );
		p.setAreaCalc( new TriangleAreaCalc() );
		
		System.out.println("\nTriangle");
		System.out.println("Points: "+p.getPoints());
		System.out.println("Area: "+p.getArea());
		System.out.println("Centroid: " +p.getCentroid());
	}

}
