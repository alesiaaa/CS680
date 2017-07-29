package edu.umb.cs.cs680;

import java.util.Comparator;

public class PriceComparator implements Comparator<Car> {


	@Override
	public int compare(Car car1, Car car2) {
		int price = (int) car2.getPrice().compareTo(car1.getPrice());
		
		return price;
	}

}
