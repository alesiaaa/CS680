package edu.umb.cs.cs680;

import java.util.EventObject;

public class BondEvent extends EventObject{
	
	private static final long serialVersionUID = -6074432010544819266L;
	private Float quote;
	private String ticker;

	public BondEvent(Object source, float quote, String ticker) {
		super (source);
		this.quote = quote;
		this.ticker = ticker;
	}
	
	public BondEvent (BondEvent event) {
		super (event.source);
		this.quote = event.getQuote();
		this.ticker = event.getTicker();
	}
	
	public void setQuote(float quote) {
		this.quote = quote;
		
	}
	
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	
	public float getQuote() {
		return this.quote;
	}

	
	public String getTicker() {
		return this.ticker;
	}

}
