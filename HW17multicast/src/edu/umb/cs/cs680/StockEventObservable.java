package edu.umb.cs.cs680;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.Observable;

public class StockEventObservable extends Observable{
	
	private ArrayList<StockEventObserver> collection;
	private StockEvent event = null; 
	
	StockEventObservable (){
		
	}
	
	public void addEventListner(EventListener el){
		
		if (this.collection == null){
			collection = new ArrayList<StockEventObserver> ();
		}
		
		this.collection.add((StockEventObserver) el);
	}
	
	
	public void notifyObservers(StockEvent ev){
		
		for (StockEventObserver o: this.collection){
			o.updateStock(this.event = new StockEvent (this, ev.getQuote(), ev.getTicker()));
		}
		
	}
	
	public StockEvent getLastEvent(){
		return this.event;
	}
	
	public static void main (String args[]){
		Test test = new Test();
		test.run();
	}
		
	

}
