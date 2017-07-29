package edu.umb.cs.cs680;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import edu.umb.cs.cs680.Point;

public class RectangleTest {

	@Test
	public void compareRectanglePointsWithItself(){
		ArrayList<Point> cut = new ArrayList<Point>();
		cut.add(new Point(18,-5));
		cut.add(new Point(-5,-5));
		cut.add(new Point(-5,-13));
		cut.add(new Point(18,-13));
		
		Polygon p = new Polygon( cut, new RectangleAreaCalc() );
		
		ArrayList<Point> actual = p.getPoints();
		
		ArrayList<Point> expected = p.getPoints();
		
		System.out.println("\nRectangle: Compare with itself");
		System.out.println("R1 -> "+ actual.toString());
		System.out.println("R2 -> "+ expected.toString());
		if (actual.equals(expected)){System.out.println("Rectangles are the same.");}
		else {System.out.println("Rectangles are different.");}
		
		assertThat(expected==actual, is(true));
	}
	
	@Test
	public void compareRectangleAreaWithDifferentArea(){
		ArrayList<Point> cut = new ArrayList<Point>();
		cut.add(new Point(18,-5));
		cut.add(new Point(-5,-5));
		cut.add(new Point(-5,-13));
		cut.add(new Point(18,-13));
		
		Polygon p = new Polygon( cut, new RectangleAreaCalc() );
		
		ArrayList<Point> cut1 = new ArrayList<Point>(); 
		cut1.add(new Point(10,15));
		cut1.add(new Point(20,15));
		cut1.add(new Point(20,5));
		cut1.add(new Point(10,5));
		
		Polygon p1 = new Polygon( cut1, new RectangleAreaCalc() );
		
		float actual = p.getArea();
		
		float expected = p1.getArea();
		
		System.out.println("\nRectangle: Compare with different areas");
		System.out.println("R1 area: "+ actual);
		System.out.println("R2 area: "+ expected);
		if (actual!=expected){System.out.println("Rectangles have different areas.");}
		
		assertThat(expected==actual, is(false));
	}
	
	
	@Test
	public void validateRectangleArea(){
		ArrayList<Point> cut = new ArrayList<Point>();
		 
		cut.add( new Point(10,15));
		cut.add( new Point(20,15));
		cut.add( new Point(20,5));
		cut.add( new Point(10,5) );
		
		Polygon p = new Polygon( cut, new RectangleAreaCalc() );
		 
		float actual = p.getArea();
		
		float expected = 100;
		
		System.out.println("\nRectangle: Validate area");
		System.out.println("Expected area: "+ expected);
		System.out.println("Actual area: "+ actual);
		if (actual==expected){System.out.println("Area is correct.");}
		
		assertThat(actual, is(expected)); 
	}
	
	@Test
	public void validateRectangleCentroid(){
		
		ArrayList<Point> cut = new ArrayList<Point>();
		 
		cut.add(new Point(3,9));
		cut.add(new Point(3,0));
		cut.add(new Point(9,0));
		cut.add(new Point(9,3));
		
		Polygon p = new Polygon( cut, new RectangleAreaCalc() );
		 
		Point actual = p.getCentroid();
		
		Point expected = new Point (6f, 3f);
		
		System.out.println("\nRectangle: Validate centroid");
		System.out.println("Expected centroid: "+ expected);
		System.out.println("Actual centroid: "+ actual);
		if (actual==expected){System.out.println("Centroid is correct.");}
		
		
		assertThat(actual, is(expected)); 
	}
	
	@Test
	public void convertTriangleToRectangle(){
		ArrayList<Point> cut = new ArrayList<Point>();
		cut.add(new Point(18,-5));
		cut.add(new Point(-5,-5));
		cut.add(new Point(-5,-13));
		
		Polygon p = new Polygon( cut, new TriangleAreaCalc() );
		
		System.out.println("\nRectangle: Convert triangle to rectangle");
		System.out.println("T1 -> "+ p.getPoints());
		
		p.addPoint(new Point(18,-13));
		p.setAreaCalc(new RectangleAreaCalc() );
		
		System.out.println("Add a point.");
		System.out.println("R1 -> "+ p.getPoints());
		
		float actual = p.getPoints().size();
		
		float expected = 4;
		
		assertThat(expected==actual, is(true)); 
	}

}
