package edu.umb.cs.cs680;

public class StockQuoteObservable extends Observable{
	
	public void changeQuote(String t, float q){
		this.setChanged();
		this.notifyObservers(event = new StockEvent(q, t));
	}

}
