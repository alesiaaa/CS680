package edu.umb.cs.cs680;
import java.util.*;

public class TimeStampComparator implements Comparator<FSElement> {

	@Override
	public int compare(FSElement e1, FSElement e2) {
		
		Date d1 = e1.getLastModified();
		Date d2 = e2.getLastModified();
		
		if (d1.after(d2)) {
	        return -1;
	        
	    } else if (d1.before(d2)) {
	        return 1;
	        
	    } else{
	    	return 0;
	    }

	}

}
