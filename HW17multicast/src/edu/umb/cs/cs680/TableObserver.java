package edu.umb.cs.cs680;

import java.util.EventObject;

public class TableObserver implements 
	BondEventObserver, 
	StockEventObserver,
	DJIAEventObserver {
	
	private EventObject event = null;
	private String ticker = null;
	private float quote = 0;
	
	
	@Override
	public void updateDJIA(DJIAEvent e) {
		this.event = e;
		this.ticker = ((DJIAEvent) e).getTicker();
		this.quote = ((DJIAEvent) e).getQuote();
		
		if (this.event !=null){
			print();
		}
	}

	@Override
	public void updateStock(StockEvent e) {
		this.event = e;
		this.ticker = ((StockEvent) e).getTicker();
		this.quote = ((StockEvent) e).getQuote();
		
		if (this.event !=null){
			print();
		}
		
	}

	@Override
	public void updateBond(BondEvent e) {
		this.event = e;
		this.ticker = ((BondEvent) e).getTicker();
		this.quote = ((BondEvent) e).getQuote();
		
		if (this.event !=null){
			print();
		}
		
	}
	
	private void print(){
		StringBuilder sb = new StringBuilder ();
		sb.append("Table Observer\n");
		sb.append("Company: " + this.ticker + " | $ " + this.quote + "\n");
		System.out.print(sb);
		
	}
	
}
