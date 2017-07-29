package edu.umb.cs.cs680;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.Observable;

public class DJIAEventObservable extends Observable{
	
	private ArrayList<DJIAEventObserver> collection;
	private DJIAEvent event = null; 
	
	DJIAEventObservable(){
		//blank
	}
	
	public void addEventListner(EventListener el){
		
		if (this.collection == null){
			this.collection = new ArrayList<DJIAEventObserver> ();
		}
		
		this.collection.add((DJIAEventObserver) el);
		
		System.out.println("here");
		
	}
	
	
	public void notifyObservers(DJIAEvent ev){
		
		
		
		for (DJIAEventObserver o: this.collection){
			o.updateDJIA(this.event = new DJIAEvent (this, ev.getQuote(), ev.getTicker()));
		}
		
	}
	
	public DJIAEvent getLastEvent(){
		return this.event;
	}
	
}