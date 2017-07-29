package edu.umb.cs.cs680;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;

public class Car{
	
	private String name;
	private BigDecimal price;
	private int year;
	private float mileage;
	private int wheelDrive;
	private boolean cruiseControl;
	private boolean sunroof;
	
	// empty constructor to set default values
	public Car (){
		this.name = "None";
		this.price = new BigDecimal(0.0);
		this.year = 0;
		this.mileage = 0;
		
	}
	
	// basic constructor to set minimum values
	public Car (String name, BigDecimal price, int year, float mileage){
		this.name = name;
		this.price = price;
		this.year = year;
		this.mileage = mileage;		
	}
	
	
	// constructor to set all possible values
	public Car (String name, BigDecimal price, int year, float mileage, int wheelDrive, boolean cruiseControl, boolean sunroof){
		this.name = name;
		this.price = price;
		this.year = year;
		this.mileage = mileage;
		this.wheelDrive = wheelDrive;
		this.cruiseControl = cruiseControl;
		this.sunroof = sunroof;
	}
	
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setPrice(BigDecimal price){
		this.price = price;
	}
	public void setYear(int year){
		this.year = year;
	}
	public void setMileage(float mileage){
		this.mileage = mileage;
	}
	public void setWheelDrive(int wheelDrive){
		this.wheelDrive = wheelDrive;
	}
	public void setCruiseControl(boolean cruiseControl){
		this.cruiseControl = cruiseControl;
	}
	public void setSunroof(boolean sunroof){
		this.sunroof = sunroof;
	}
	
	public String getName(){
		return this.name;
	}
	public BigDecimal getPrice(){
		return this.price;
	}
	public int getYear(){
		return this.year;
	}
	public float getMileage(){
		return this.mileage;
	}
	public int getWheelDrive(){
		return this.wheelDrive;
	}
	public boolean getCruiseControl(){
		return this.cruiseControl;
	}
	public boolean getSunroof(){
		return this.sunroof;
	}
	
	public boolean equals(Car car) {
		if (this == car || (this.getName().equals(car.getName()) &&
				(this.getYear()==(car.getYear()) && car instanceof Car ))){
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public String toString()
	{
		return this.name;
	}

	public int getDominationCount(){
		
		//TODO
		return 0;
		
	}

	
	
	public static void main(String args[]){
		Car car1 = new Car("Toyota Corolla", new BigDecimal(4000), 2010, 74000f);
		Car car2 = new Car("Volkswagen Gulf", new BigDecimal(7000), 2012, 170000f);
		Car car3 = new Car("Honda Civic", new BigDecimal(6000), 2012, 100000f);
		Car car4 = new Car("Audi A4", new BigDecimal(15000), 2014, 50000f);
		
		ArrayList<Car> actual = new ArrayList<Car>();
		
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
		
		System.out.println("Sort Cars by Price (high to low):");
		System.out.println("\nActual: ");
		for (Car c: actual){
			System.out.println(c.getName() + " (" + c.getPrice() + ")");
		}
		
		System.out.println("\nExpected: ");
		for (Car c: expected){
			System.out.println(c.getName() + " (" + c.getPrice() + ")");
		}
	}
	
	
}
