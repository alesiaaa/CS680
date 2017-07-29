package edu.umb.cs.cs680;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class SavingsAccountTest {

	@Test
	public void testGetBalance2000() {
		Account cut = new CheckingAccount (2000);
		float actual = cut.getBalance();
		float expected = 2000;
		
		System.out.println("\nSavings Account: Check balance");
		System.out.println("Expected balance: "+ expected);
		System.out.println("Actual balance: "+ actual);
		if (actual==expected){System.out.println("Balance is correct.");}
		
		
		assertThat(actual, is(expected));
	}

	@Test
	public void testWithdraw200() throws InsufficientFundsException {
		Account cut = new SavingsAccount (2000);
		cut.withdraw(200);
		float actual = cut.getBalance();
		float expected = 1800;
		
		System.out.println("\nSavings Account: Withdraw $200");
		System.out.println("Expected balance: "+ expected);
		System.out.println("Actual balance: "+ actual);
		if (actual==expected){System.out.println("Balance is correct.");}
		
		
		assertThat(actual, is(expected));
	}
	
	@Test
	public void testDeposit200() {
		Account cut = new SavingsAccount (1000);
		cut.deposit(200);
		float actual = cut.getBalance();
		float expected = 1200;
		
		System.out.println("\nSavings Account: Deposit $200");
		System.out.println("Expected balance: "+ expected);
		System.out.println("Actual balance: "+ actual);
		if (actual==expected){System.out.println("Balance is correct.");}
		
		
		
		assertThat(actual, is(expected));
	}
	

	@Test (expected=InsufficientFundsException.class)
	public void testOverdrawFunds() throws InsufficientFundsException{
		Account cut = new SavingsAccount (99);
		cut.withdraw(100);
	}

	@Test
	public void testEmptyCheckingAccountConstructor() {
		Account cut = new SavingsAccount ();
		float actual = cut.getBalance();
		float expected = 0;
		
		System.out.println("\nSavings Account: Check empty constructor");
		System.out.println("Expected balance: "+ expected);
		System.out.println("Actual balance: "+ actual);
		if (actual==expected){System.out.println("Constructor created correctly.");}
		
		
		
		assertThat(actual, is(expected));
	}

	@Test
	public void testNonemptyCheckingAccountConstructor() {
		Account cut = new SavingsAccount (24000);
		float actual = cut.getBalance();
		float expected = 24000;
		
		System.out.println("\nSavings Account: Check non-empty constructor");
		System.out.println("Expected balance: "+ expected);
		System.out.println("Actual balance: "+ actual);
		if (actual==expected){System.out.println("Constructor created correctly.");}
		
		
		assertThat(actual, is(expected));
	}

}
