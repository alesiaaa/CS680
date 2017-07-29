package edu.umb.cs.cs680;

import java.util.Comparator;

public class AlphabeticalComparator implements Comparator<FSElement> {

	@Override
	public int compare(FSElement e1, FSElement e2) {
		
		int compare = e1.getName().compareToIgnoreCase(e2.getName());
		    
		if (compare < 0){  
		    //e1 is smaller
			return -1;
		} else if (compare > 0) {
		    //e1 is larger 
			   return 1;
		} else {  
		    //e1 is equal to e2
			   return 0;
		   } 

	}

}
