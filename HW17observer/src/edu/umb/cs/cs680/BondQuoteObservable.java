package edu.umb.cs.cs680;

public class BondQuoteObservable extends Observable{
	
	public void changeQuote(String t, float q){
		this.setChanged();
		this.notifyObservers(event = new BondEvent(q, t));
	}

}