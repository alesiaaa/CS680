package edu.umb.cs.cs680;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TriangleTest {

	@Test
	public void compareTrianglePointsWithItself(){
		Triangle cut = new Triangle ( 
				new Point(2,4),
				new Point(4,1),
				new Point(-2,-1) );
		
		ArrayList <Point> actual = new ArrayList <Point> ();
		ArrayList <Point> expected = new ArrayList <Point> ();
		
		actual.addAll(cut.getPoints());
		
		expected.addAll(cut.getPoints());
		
		
		System.out.println("\nTriangle: Compare with itself");
		System.out.println("T1 -> "+ actual.toString());
		System.out.println("T2 -> "+ expected.toString());
		if (actual.equals(expected)){System.out.println("Triangles are the same.");}
		else {System.out.println("Triangles are different.");}
		
		
		assertThat(expected.equals(actual), is(true)); 
	}
	
	@Test
	public void compareTrianglePointsWithDifferentPoints(){
		Triangle cut = new Triangle ( 
				new Point(2,4),
				new Point(4,1),
				new Point(-2,-1) );
		
		ArrayList <Point> actual = new ArrayList <Point> ();
		ArrayList <Point> expected = new ArrayList <Point> ();
		
		actual.addAll(cut.getPoints());
		
		Triangle newT = new Triangle (
				new Point(10,15),
				new Point(20,15),
				new Point(10,5) );
		
		expected.addAll(newT.getPoints());
		
		System.out.println("\nTriangle: Compare with a different triangle");
		System.out.println("T1 -> "+ actual.toString());
		System.out.println("T2 -> "+ expected.toString());
		if (!actual.equals(expected)){System.out.println("Triangles are different.");}
		else {System.out.println("Triangles are the same.");}
		
		assertThat(expected.equals(actual), is(false));
	}
	
	@Test
	public void validateTriangleArea(){
		Triangle cut = new Triangle ( 
				new Point(10,15),
				new Point(20,15),
				new Point(10,5) );
		
		double actual = cut.getArea();
		
		double expected = 50.0;
		
		System.out.println("\nTriangle: Validate area");
		System.out.println("Expected area: "+ expected);
		System.out.println("Actual area: "+ actual);
		
		if (actual==expected){System.out.println("Area is correct.");}
		else {System.out.println("Area is incorrect.");}
		
		assertThat(actual, is(expected)); 
	}


}
