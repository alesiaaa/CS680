package edu.umb.cs.cs680;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ObserverTest {
	
	StockQuoteObservable stockQuoteObservable = null;
	PiechartObserver piechartObserver = null;
	TableObserver tableObserver = null; 
	ThreeDObserver threeDObserver = null;

	@Before
	public void setUp(){
		stockQuoteObservable = new StockQuoteObservable ();
	
		piechartObserver = new PiechartObserver();
		tableObserver = new TableObserver();
		threeDObserver = new ThreeDObserver ();
	}
	
	
	@Test
	public void observerTest() {
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
		
		assertThat(stockQuoteObservable.getLastEvent().getQuote(), is(99f));
		
	}
	
	@After
	public void cleanUp(){
		stockQuoteObservable = null;
	
		piechartObserver = null;
		tableObserver = null;
		threeDObserver = null;
	}

}
