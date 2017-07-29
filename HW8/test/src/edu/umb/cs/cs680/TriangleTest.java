package edu.umb.cs.cs680;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import edu.umb.cs.cs680.Point;

public class TriangleTest {

	@Test
	public void compareTrianglePointsWithItself(){
		ArrayList<Point> cut = new ArrayList<Point>();
		cut.add(new Point(2,4));
		cut.add(new Point(4,1));
		cut.add(new Point(-2,-1));
		
		Polygon p = new Polygon( cut, new TriangleAreaCalc() );
		
		ArrayList<Point> actual = p.getPoints();
		
		ArrayList<Point> expected = p.getPoints();
		
		System.out.println("\nTriangle: Compare with itself");
		System.out.println("T1 -> "+ actual.toString());
		System.out.println("T2 -> "+ expected.toString());
		if (actual.equals(expected)){System.out.println("Triangles are the same.");}
		
		assertThat(expected==actual, is(true)); 
	}
	
	@Test
	public void compareTriangleAreaWithDifferentArea(){
		ArrayList<Point> cut = new ArrayList<Point>();
		cut.add(new Point(2,4));
		cut.add(new Point(4,1));
		cut.add(new Point(-2,-1));
		
		Polygon p = new Polygon( cut, new TriangleAreaCalc() );
		
		ArrayList<Point> cut1 = new ArrayList<Point>();
		cut1.add(new Point(10,15));
		cut1.add(new Point(20,15));
		cut1.add(new Point(10,5));
		
		Polygon p1 = new Polygon( cut1, new TriangleAreaCalc() );
		
		float actual = p.getArea();
				
		float expected = p1.getArea();
		
		System.out.println("\nTriangle: Compare with different areas");
		System.out.println("T1 area: "+ actual);
		System.out.println("T2 area: "+ expected);
		if (actual!=expected){System.out.println("Triangles have different areas.");}
		
		assertThat(expected!=actual, is(true));
	}
	
	@Test
	public void validateTriangleArea(){
		
		ArrayList<Point> cut = new ArrayList<Point>();
		 
		cut.add(new Point(10,15));
		cut.add(new Point(20,15));
		cut.add(new Point(10,5));
		
		Polygon p = new Polygon( cut, new TriangleAreaCalc() );
		 
		float actual = p.getArea(); // triangle’s area
		
		float expected = 50;
		
		System.out.println("\nTriangle: Validate area");
		System.out.println("Expected area: "+ expected);
		System.out.println("Actual area: "+ actual);
		if (actual==expected){System.out.println("Area is correct.");}
		
		assertThat(actual, is(expected)); 
	}
	
	@Test
	public void validateTriangleCentroid(){
		
		ArrayList<Point> cut = new ArrayList<Point>();
		 
		cut.add(new Point(3,9));
		cut.add(new Point(3,0));
		cut.add(new Point(9,0));
		
		Polygon p = new Polygon( cut, new TriangleAreaCalc() );
		 
		Point actual = p.getCentroid(); // triangle’s centroid
		
		Point expected = new Point (5f, 3f);
		
		System.out.println("\nTriangle: Validate centroid");
		System.out.println("Expected centroid: "+ expected);
		System.out.println("Actual centroid: "+ actual);
		if (actual==expected){System.out.println("Centroid is correct.");}
		
		assertThat(actual, is(expected)); 
	}
	
	@Test
	public void convertRectangleToTriangle(){
		ArrayList<Point> cut = new ArrayList<Point>();
		cut.add(new Point(18,-5));
		cut.add(new Point(-5,-5));
		cut.add(new Point(-5,-13));
		cut.add(new Point(18,-13));
		
		Polygon p = new Polygon( cut, new RectangleAreaCalc() );
		
		System.out.println("\nTriangle: Convert rectangle to triangle");
		System.out.println("R1 -> "+ p.getPoints());
		
		p.removePoint(new Point(18,-13));
		p.setAreaCalc(new TriangleAreaCalc() );
		System.out.println("Remove a point.");
		System.out.println("T1 -> "+ p.getPoints());
		
		float actual = p.getPoints().size();
		
		float expected = 3;
		
		assertThat(expected==actual, is(true)); 
	}


}
