package edu.umb.cs.cs680;

import java.util.Comparator;

public class MileageComparator implements Comparator<Car>{

	@Override
	public int compare(Car car1, Car car2) {
		
		if (car1.getMileage() < car2.getMileage()) {
	        return -1;
	        
	    } else if (car1.getMileage() > car2.getMileage()) {
	        return 1;
	        
	    } else{
	    	
	    	return 0;
	    }
	}

	
}
