package edu.umb.cs.cs680;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.umb.cs.cs680.PiechartObserver;
import edu.umb.cs.cs680.TableObserver;
import edu.umb.cs.cs680.ThreeDObserver;

public class MulticastTest {
	
	PiechartObserver piechartObserver = null;
	TableObserver tableObserver = null;
	ThreeDObserver threeDObserver = null;
	
	StockEventObservable stockEventObservable = null;
	BondEventObservable bondEventObservable = null;
	DJIAEventObservable djiaEventObservable = null;
	
	@Before
	public void setUp(){
	
		piechartObserver = new PiechartObserver();
		tableObserver = new TableObserver();
		threeDObserver = new ThreeDObserver ();
		
	}
	
	@After
	public void cleanUp(){
	
		piechartObserver = null;
		tableObserver = null;
		threeDObserver = null;
	}
	
	@Test
	public void StockEventObservableTest() {
		stockEventObservable = new StockEventObservable();
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
		
		
		
		assertThat(stockEventObservable.getLastEvent().getQuote(), is(99f));
		
	}
	
	@Test
	public void BondEventObservableTest() {
		
		bondEventObservable = new BondEventObservable ();
		bondEventObservable.addEventListner(piechartObserver);
		bondEventObservable.addEventListner(tableObserver);
		bondEventObservable.addEventListner(threeDObserver);
		
		float [] quotes = {700f, 70f, 34f, 9f};
		String [] company = {"Super Awesome Company II",
				"Another Company II", "New Company II"};

		for (float f: quotes){
			try {
			
				//periodic delay for testing purposes
				Thread.sleep(1000);// 1 second
			
				for (String s: company){
					bondEventObservable.notifyObservers(new BondEvent (this, f, s));
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		assertThat(bondEventObservable.getLastEvent().getQuote(), is(9f));
		
	}
	
	@Test
	public void DJIAEventObservableTest() {
		
		djiaEventObservable = new DJIAEventObservable ();
		djiaEventObservable.addEventListner(piechartObserver);
		djiaEventObservable.addEventListner(tableObserver);
		djiaEventObservable.addEventListner(threeDObserver);
		
		float [] quotes = {700f, 70f, 34f, 19f};
		String [] company = {"Super Awesome Company III",
				"Another Company III", "New Company III"};
		
		for (float f: quotes){
			
			try {
			
				//periodic delay for testing purposes
				Thread.sleep(1000);// 1 second
			
				for (String s: company){
					djiaEventObservable.notifyObservers(new DJIAEvent (this, f, s));
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		assertThat(djiaEventObservable.getLastEvent().getQuote(), is(19f));
		
	}

}
