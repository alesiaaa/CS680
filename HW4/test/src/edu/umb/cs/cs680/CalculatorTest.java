package edu.umb.cs.cs680;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;

import edu.umb.cs.cs680.Calculator;


public class CalculatorTest {

	@Test
	public void multiply3By4(){
		Calculator cut = new Calculator();
		float expected = 12;
		float actual = cut.multiply(3,4);
		
		System.out.println("\nMuliply: 3x4 = " + actual);
		if (actual==expected){System.out.println("Result is correct.");}
		else {System.out.println("Result is wrong.");}
		
		assertThat(actual, is(expected)); 
	}
	
	@Test
	public void divide3By2(){
		Calculator cut = new Calculator();
		float expected = 1.5f;
		float actual = cut.divide(3,2);
		
		System.out.println("\nDivide: 3/2 = " + actual);
		if (actual==expected){System.out.println("Result is correct.");}
		else {System.out.println("Result is wrong.");}
		
		assertThat(actual, is(expected)); 
	}
	
	@Test(expected=IllegalArgumentException.class) 
	public void divide5By0(){
		Calculator cut = new Calculator();
		cut.divide(5,0); 
		
		System.out.println("\nDivide: 5/0");
		
	}
	
	@Test
	public void divide10By0(){
		Calculator cut = new Calculator();
		try {
			System.out.println("\nDivide: 10/0");
			cut.divide(10,0);
			fail("Cannot divide by zero.");
			
		} catch (IllegalArgumentException e) {
			// exception is expected
			e = new IllegalArgumentException("Cannot divide by zero.");
			System.out.println(e.getMessage());
		}
		
	}
	
	@Test
	public void multiply2_5By5_5(){
		Calculator cut = new Calculator();
		float expected = 13.75f;
		float actual = cut.multiply(2.5f,5.5f);
		
		System.out.println("\nMultiply: 2.5x5.5 = " + actual);
		if (actual==expected){System.out.println("Result is correct.");}
		else {System.out.println("Result is wrong.");}
		
		assertThat(actual, is(expected)); 
	}
	
	@Test
	public void divide2_5By5_5(){
		Calculator cut = new Calculator();
		float expected = 2.5f/5.5f;
		float actual = cut.divide(2.5f,5.5f);
		
		System.out.println("\nDivide: 2.5/5.5 = " + actual);
		if (actual==expected){System.out.println("Result is correct.");}
		else {System.out.println("Result is wrong.");}
		
		assertThat(actual, is(expected)); 
	}
	
	@Test
	public void add8and8(){
		Calculator cut = new Calculator();
		float expected = 16;
		float actual = cut.add(8,8);
		
		System.out.println("\nAdd: 8 + 8 = " + actual);
		if (actual==expected){System.out.println("Result is correct.");}
		
		assertThat(actual, is(expected)); 
	}
	
	@Test
	public void subtract7and3(){
		Calculator cut = new Calculator();
		float expected = 4;
		float actual = cut.subtract(7,3);
		
		System.out.println("\nSubtract: 7 - 3 = " + actual);
		if (actual==expected){System.out.println("Result is correct.");}
		
		assertThat(actual, is(expected)); 
	}
	
}
