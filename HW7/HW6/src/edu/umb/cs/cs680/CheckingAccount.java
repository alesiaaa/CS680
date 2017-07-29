package edu.umb.cs.cs680;

public class CheckingAccount extends Account{

	public CheckingAccount(){
		this.balance = 0;
	}
	
	public CheckingAccount(float b){
		this.balance = b;
	}
	
	@Override
	public float getBalance(){	
		return this.balance;
	}
	
	@Override
	public void withdraw(float w) throws InsufficientFundsException{
		
		float updatedBalance = getBalance() - w;
		
		if (this.getBalance() >= w ){
			this.balance = updatedBalance;
		}
		
		else if (this.getBalance() < w){
				
				 throw new InsufficientFundsException("Balance must not fall below $0. "
					 		+"Insufficient funds for withdrawal.");
		}
	
	}
	
	@Override
	public void withdraw(float w, Account savingsAccount) throws InsufficientFundsException{
		
		float updatedBalance = this.getBalance() - w;
		float penalty = 50;
		
		if (updatedBalance < 0) {
			
			//Check if you can withdraw from savings too
			//Apply penalty
			
			float needMoneyFromSavings =  w - this.balance;
			
			if (savingsAccount.getBalance()-needMoneyFromSavings-penalty >= 0){
			
				this.balance = 0;
				savingsAccount.withdraw(needMoneyFromSavings+penalty);
				
			} else{
				
				//If savings falls below zero throw exception
				throw new InsufficientFundsException("Balance must not fall below $0. "
				 		+"Insufficient funds for withdrawal.");
				
			}
			
			
		} else if (updatedBalance >= 0){
			
			this.balance = updatedBalance;
		
		}
	
	}
	
	public static void main(String args[]) throws InsufficientFundsException{
		
		Account checking = new CheckingAccount (150);
		System.out.println("Open new Checking Account. Balance: $" + checking.getBalance());
		
		Account savings = new SavingsAccount (2000);
		System.out.println("Open new Savings Account. Balance: $" + savings.getBalance());
		
		savings.withdraw(200);
		System.out.println("Withdraw $200 from Savings. Balance: $" + savings.getBalance());
		
		checking.withdraw(100);
		System.out.println("Withdraw $100 from Checking. Balance: $" + checking.getBalance());
		
		checking.deposit(300);
		System.out.println("Deposit $300 to Checking. Balance: $" + checking.getBalance());
		
		savings.deposit(1000);
		System.out.println("Deposit $1000 to Savings. Balance: $" + savings.getBalance());
		
		checking.withdraw(400, savings);
		System.out.println("Withdraw $400 from Checking & Savings. "
				+ "\n Checking Balance: $ " + checking.getBalance()
				+ "\n Savings Balance: $ " + savings.getBalance());
		
	}
	
	
}
