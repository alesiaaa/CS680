package edu.umb.cs.cs680;

import java.util.EventListener;

public interface StockEventObserver extends EventListener{

	public void updateStock(StockEvent e);
	
}
