package edu.umb.cs.cs680;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class RectangleTest {

	@Test
	public void compareRectanglePointsWithItself(){
		Rectangle cut = new Rectangle ( 
				new Point(18,-5),
				new Point(-5,-5),
				new Point(-5,-13), 
				new Point(18,-13) );
		
		ArrayList <Point> actual = new ArrayList <Point> ();
		ArrayList <Point> expected = new ArrayList <Point> ();
		
		actual.addAll(cut.getPoints());
		
		expected.addAll(cut.getPoints());
		
		System.out.println("\nRectangle: Compare with itself");
		System.out.println("R1 -> "+ actual.toString());
		System.out.println("R2 -> "+ expected.toString());
		if (actual.equals(expected)){System.out.println("Rectangles are the same.");}
		else {System.out.println("Rectangles are different.");}
		
		assertThat(expected.equals(actual), is(true));
	}
	
	@Test
	public void compareRectanglePointsWithDifferentPoints(){
		Rectangle cut = new Rectangle ( 
				new Point(18,-5),
				new Point(-5,-5),
				new Point(-5,-13), 
				new Point(18,-13) );
		
		ArrayList <Point> actual = new ArrayList <Point> ();
		ArrayList <Point> expected = new ArrayList <Point> ();
		
		actual.addAll(cut.getPoints());
		
		Rectangle newR = new Rectangle (  
				new Point(10,15),
				new Point(20,15),
				new Point(20,5),
				new Point(10,5) );
		
		expected.addAll(newR.getPoints());
		
		System.out.println("\nRectangle: Compare with a different rectangle");
		System.out.println("R1 -> "+ actual.toString());
		System.out.println("R2 -> "+ expected.toString());
		if (!actual.equals(expected)){System.out.println("Rectangles are different.");}
		else {System.out.println("Rectangles are the same.");}
		
		assertThat(expected.equals(actual), is(false));
	}
	
	
	@Test
	public void validateRectangleArea(){
		Rectangle cut = new Rectangle (  
					new Point(10,15),
					new Point(20,15),
					new Point(20,5),
					new Point(10,5) );
		
		double actual = cut.getArea();
		
		double expected = 100.0;
		
		System.out.println("\nRectangle: Validate area");
		System.out.println("Expected area: "+ expected);
		System.out.println("Actual area: "+ actual);
		
		if (actual==expected){System.out.println("Area is correct.");}
		else {System.out.println("Area is incorrect.");}
		
		assertThat(actual, is(expected)); 
	}

}
