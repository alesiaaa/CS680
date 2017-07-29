package edu.umb.cs.cs680;

public class SavingsAccount extends Account{

	public SavingsAccount(){
		this.balance = 0;
	}
	
	public SavingsAccount(float b){
		this.balance = b;
	}
	
	//@Override
	public float getBalance(){	
		return this.balance;
	}
	
	@Override
	public void withdraw(float w) throws InsufficientFundsException {
				
		float updatedBalance = getBalance() - w;
		
		if (updatedBalance >= 0){
			this.balance = updatedBalance;
		}
		else if (updatedBalance < 0){

			 throw new InsufficientFundsException("Balance must not fall below $0.\n"
			 		+ "Insufficient funds for withdrawal.");
		}
	
	}
	
	
}
