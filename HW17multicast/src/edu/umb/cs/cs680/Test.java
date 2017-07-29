package edu.umb.cs.cs680;

public class Test {
	
	
	Test(){
		
	}
	
	public void run (){
		StockEventObservable stockEventObservable = new StockEventObservable();
		PiechartObserver piechartObserver = new PiechartObserver();
		TableObserver tableObserver = new TableObserver();
		ThreeDObserver threeDObserver = new ThreeDObserver ();
		
		stockEventObservable.addEventListner(piechartObserver);
		stockEventObservable.addEventListner(tableObserver);
		stockEventObservable.addEventListner(threeDObserver);
		
		float [] quotes = {50f, 25f, 30f, 99f};
		String [] company = {"Super Awesome Company",
				"Another Company", "New Company"};
		
			for (float f: quotes){
				try {
				
					//periodic delay for testing purposes
					Thread.sleep(1000);// 1 second
				
					for (String s: company){
						stockEventObservable.notifyObservers(new StockEvent (this, f, s));
					}
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
	
	}


}
