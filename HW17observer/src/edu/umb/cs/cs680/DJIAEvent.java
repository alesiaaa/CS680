package edu.umb.cs.cs680;


public class DJIAEvent implements Event {

	private Float quote;
	private String ticker;

	public DJIAEvent(float quote, String ticker) {
		this.quote = quote;
		this.ticker = ticker;
	}

	@Override
	public void setQuote(float quote) {
		this.quote = quote;
		
	}

	@Override
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	@Override
	public float getQuote() {
		return this.quote;
	}

	@Override
	public String getTicker() {
		return this.ticker;
	}

}
