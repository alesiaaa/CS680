package edu.umb.cs.cs680;

import java.util.ArrayList;

public class Observable {
	
	public ArrayList<Observer> observerList;
	private boolean changed = false;
	protected Event event = null;

	public Observable() {
		observerList = new ArrayList<Observer>();
	}
	
	public void addObserver(Observer o){
		this.observerList.add(o);
	}
	
	public void setChanged(){
		this.changed = true;
	}
	
	
	public boolean hasChanged(){
		return this.changed;
	}
	
	
	public void clearChanged(){
		this.changed = false;
	}
	
	public void notifyObservers(){
		Object o = null;
		notifyObservers(o);
	}
	
	
	public void notifyObservers (Object arg) {
		
		if (this.hasChanged() == true){
			
			//notify of changes
			for (Observer obs: this.observerList){
				obs.update(this, arg);
				
			}
			
			//reset changed status after called in each observer
			clearChanged();
			
		}
	}
	
	public Event getLastEvent(){
		return this.event;
	}
	
	public static void main (String args[]){
		StockQuoteObservable stockQuoteObservable = new StockQuoteObservable ();
		PiechartObserver piechartObserver = new PiechartObserver();
		TableObserver tableObserver = new TableObserver();
		ThreeDObserver threeDObserver = new ThreeDObserver ();
		
		stockQuoteObservable.addObserver(piechartObserver);
		stockQuoteObservable.addObserver(tableObserver);
		stockQuoteObservable.addObserver(threeDObserver);
		
		float [] quotes = {50f, 25f, 30f, 99f};
		String [] company = {"Super Awesome Company",
				"Another Company", "New Company"};
		
		
		for (float f: quotes){
			
			try {	
				//periodic delay for testing purposes
				Thread.sleep(1000);// 1 second
				
				for (String s: company){
					stockQuoteObservable.changeQuote(s, f);
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
				
		}
		
		
		
	}
	
	
	

}
