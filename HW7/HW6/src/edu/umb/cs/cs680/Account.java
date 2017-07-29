package edu.umb.cs.cs680;

public class Account {
	
	protected float balance;
	
	public Account (){
		this.balance = 0;
	}
	
	public Account (float b){
		this.balance = b;
	}
	
	public float getBalance(){	
		return this.balance;
	}
	
	public float deposit(float d){	
		this.balance+=d;
		return this.balance;
	}
	
	// empty method
	public void withdraw(float w) throws InsufficientFundsException{}
	
	// empty method
	public void withdraw(float w, Account a) throws InsufficientFundsException{}


}
