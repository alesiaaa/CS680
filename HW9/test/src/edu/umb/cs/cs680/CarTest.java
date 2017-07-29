package edu.umb.cs.cs680;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class CarTest {

	
	Car car1 = new Car("Toyota Corolla", new BigDecimal(4000), 2010, 74000f);
	Car car2 = new Car("Volkswagen Gulf", new BigDecimal(7000), 2012, 170000f);
	Car car3 = new Car("Honda Civic", new BigDecimal(6000), 2012, 100000f);
	Car car4 = new Car("Audi A4", new BigDecimal(15000), 2014, 50000f);
	
	ArrayList<Car> actual = new ArrayList<Car>();
	
	
	@Test
	public void compareCarMileage(){
	
		MileageComparator mc = new MileageComparator();
		int actual = mc.compare(car1, car2);
		int expected = -1;
		
		assertThat(expected, is(actual));
		
	}
	@Test
	public void compareCarPrice(){
	
		PriceComparator pc = new PriceComparator();
		int actual = pc.compare(car3, car4);
		int expected = 1;
		
		assertThat(expected, is(actual));
	}
	@Test
	public void compareCarYear(){
	
		YearComparator yc = new YearComparator();
		int actual = yc.compare(car2, car3);
		int expected = 0;
		
		
		assertThat(expected, is(actual));
	}
	
	@Test
	public void sortCarPrice(){
		actual.add(car1);
		actual.add(car2);
		actual.add(car3);
		actual.add(car4);
		
		Collections.sort(actual, new PriceComparator());
		
		ArrayList<Car> expected = new ArrayList<Car>();
		expected.add(car4);
		expected.add(car2);
		expected.add(car3);
		expected.add(car1);
		
		System.out.println("\n\nSort Cars by Price:");
		System.out.println("\nActual: ");
		for (Car c: actual){
			System.out.print(c.getName() + " (" + c.getPrice() + "), ");
		}
		
		System.out.println("\nExpected: ");
		for (Car c: expected){
			System.out.print(c.getName() + " (" + c.getPrice() + "), ");
		}
		
		
		assertThat(expected, is(actual));
	}
	
	@Test
	public void sortCarMileage(){
		actual.add(car1);
		actual.add(car2);
		actual.add(car3);
		actual.add(car4);
		
		Collections.sort(actual, new MileageComparator());
		
		ArrayList<Car> expected = new ArrayList<Car>();
		expected.add(car4);
		expected.add(car1);
		expected.add(car3);
		expected.add(car2);
		
		System.out.println("\n\nSort Cars by Mileage:");
		System.out.println("\nActual: ");
		for (Car c: actual){
			System.out.print(c.getName() + " (" + c.getMileage() + "), ");
		}
		
		System.out.println("\nExpected: ");
		for (Car c: expected){
			System.out.print(c.getName() + " (" + c.getMileage() + "), ");
		}
		
		
		assertThat(expected, is(actual));
	}
	
	@Test
	public void sortCarYear(){
		actual.add(car1);
		actual.add(car2);
		actual.add(car3);
		actual.add(car4);
		
		Collections.sort(actual, new YearComparator());
		
		ArrayList<Car> expected = new ArrayList<Car>();
		expected.add(car1);
		expected.add(car2);
		expected.add(car3);
		expected.add(car4);
		
		
		System.out.println("\n\nSort Cars by Year:");
		System.out.println("\nActual: ");
		for (Car c: actual){
			System.out.print(c.getName() + " (" + c.getYear() + "), ");
		}
		
		System.out.println("\nExpected: ");
		for (Car c: expected){
			System.out.print(c.getName() + " (" + c.getYear() + "), ");
		}
		
		assertThat(expected, is(actual));
		
	}
	
	
	

}
