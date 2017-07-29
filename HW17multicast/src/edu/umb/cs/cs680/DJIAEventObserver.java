package edu.umb.cs.cs680;

import java.util.EventListener;

public interface DJIAEventObserver extends EventListener{

	public void updateDJIA(DJIAEvent e);
	
}
