package edu.umb.cs.cs680;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.Observable;

public class BondEventObservable extends Observable{

	private ArrayList<BondEventObserver> collection;
	private BondEvent event = null; 
	
	BondEventObservable (){
		
	}
	
	public void addEventListner(EventListener el){
		
		if (this.collection == null){
			collection = new ArrayList<BondEventObserver> ();
		}
		
		this.collection.add((BondEventObserver) el);
	}
	
	
	public void notifyObservers(BondEvent ev){
		
		for (BondEventObserver o: this.collection){
				o.updateBond(this.event = new BondEvent (this, ev.getQuote(), ev.getTicker()));
			}
		
	}
	
	public BondEvent getLastEvent(){
		return this.event;
	}
	
}