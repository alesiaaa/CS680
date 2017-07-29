package edu.umb.cs.cs680;

import java.util.EventListener;

public interface BondEventObserver extends EventListener{

	public void updateBond(BondEvent e);
	
}
