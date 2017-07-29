package edu.umb.cs.cs680;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
//import java.lang.Math;
import java.text.DecimalFormat;

public class Triangle implements Polygon {
		
	private ArrayList <Point> points = new ArrayList <Point> ();
	
	public Triangle (Point a, Point b, Point c){
			
		points.addAll(Arrays.asList(a, b, c));
		
	}
		
		
	public ArrayList<Point> getPoints(){
		
		return points;
		
	}
	
	public double getArea(){
		double area = 0;
		
		// Calculate distance
		
		double a = Math.sqrt( Math.pow((points.get(1).getX() - points.get(0).getX()),2) + Math.pow((points.get(1).getY() - points.get(0).getY()),2));
		
		double b = Math.sqrt( Math.pow((points.get(2).getX() - points.get(1).getX()),2) + Math.pow((points.get(2).getY() - points.get(1).getY()),2));
		
		double c = Math.sqrt( Math.pow((points.get(0).getX() - points.get(2).getX()),2) + Math.pow((points.get(0).getY() - points.get(2).getY()),2));
		
		
		// Heron's formula for triangle area
		
		double s = 0.5*(a+b+c);
		
		area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
		
		return area;
	}
		
	
	
	public static void main(String args[]){

		System.out.println("HW5 using HW2 Code for Area Calculation");
        System.out.println("by: Alesia Razumova\n");
		
		ArrayList<Polygon> p = new ArrayList<Polygon>();
		
		p.add( new Triangle( 
				new Point(2,4),
				new Point(4,1),
				new Point(-2,-1) ));
		
		p.add( new Triangle( 
				new Point(10,15),
				new Point(20,15),
				new Point(10,5) ));
		
		p.add( new Rectangle ( 
				new Point(18,-5),
				new Point(-5,-5),
				new Point(-5,-13), 
				new Point(18,-13) ));
		
		p.add( new Rectangle ( 
				new Point(10,15),
				new Point(20,15),
				new Point(20,5),
				new Point(10,5) ));
		
		Iterator<Polygon> it = p.iterator();
		while( it.hasNext() ){
			Polygon nextP = it.next();
			
			if (nextP.getPoints().size() == 3){
				System.out.println("Triangle:");
				
			} else if (nextP.getPoints().size() == 4){
				System.out.println("Square: ");
				
			}
			
			System.out.println("Coordinates: "+ nextP.getPoints());
			
			DecimalFormat decimal = new DecimalFormat("0.00");
			String formatArea = decimal.format(nextP.getArea());
			
			System.out.println("Area: " + formatArea);
			System.out.println(" ");
		}
	}
	
}
