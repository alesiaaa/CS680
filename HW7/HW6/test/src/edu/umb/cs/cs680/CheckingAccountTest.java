package edu.umb.cs.cs680;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;


public class CheckingAccountTest {

	@Test
	public void testGetBalance2000() {
		Account cut = new CheckingAccount (2000);
		float actual = cut.getBalance();
		float expected = 2000;
		
		System.out.println("\nChecking Account: Check balance");
		System.out.println("Expected balance: "+ expected);
		System.out.println("Actual balance: "+ actual);
		if (actual==expected){System.out.println("Balance is correct.");}
		
		
		assertThat(actual, is(expected));
	}

	@Test
	public void testWithdraw200() throws InsufficientFundsException {
		Account cut = new CheckingAccount (2000);
		cut.withdraw(200);
		float actual = cut.getBalance();
		float expected = 1800;
		
		System.out.println("\nChecking Account: Withdraw $200");
		System.out.println("Expected balance: "+ expected);
		System.out.println("Actual balance: "+ actual);
		if (actual==expected){System.out.println("Balance is correct.");}
		
		
		
		assertThat(actual, is(expected));
	}
	
	@Test
	public void testDeposit200() {
		Account cut = new CheckingAccount (2000);
		cut.deposit(200);
		float actual = cut.getBalance();
		float expected = 2200;
		
		System.out.println("\nChecking Account: Deposit $200");
		System.out.println("Expected balance: "+ expected);
		System.out.println("Actual balance: "+ actual);
		if (actual==expected){System.out.println("Balance is correct.");}
		
		
		
		assertThat(actual, is(expected));
	}

	@Test
	public void testEmptyCheckingAccountConstructor() {
		Account cut = new CheckingAccount ();
		float actual = cut.getBalance();
		float expected = 0;
		
		System.out.println("\nChecking Account: Check empty constructor");
		System.out.println("Expected balance: "+ expected);
		System.out.println("Actual balance: "+ actual);
		if (actual==expected){System.out.println("Constructor created correctly.");}
		
		
		assertThat(actual, is(expected));
	}

	@Test
	public void testNonemptyCheckingAccountConstructor() {
		Account cut = new CheckingAccount (24000);
		float actual = cut.getBalance();
		float expected = 24000;
		
		System.out.println("\nChecking Account: Check non-empty constructor");
		System.out.println("Expected balance: "+ expected);
		System.out.println("Actual balance: "+ actual);
		if (actual==expected){System.out.println("Constructor created correctly.");}
		
		
		assertThat(actual, is(expected));
	}
	
	@Test
	public void testWithdrawCheckingAndSavingsAccount200() throws InsufficientFundsException{
		Account cut = new CheckingAccount (300);
		Account cut2 = new SavingsAccount (2000);
		cut.withdraw(200, cut2);
		float actual = cut.getBalance();
		float expected = 100;
		
		System.out.println("\nChecking & Savings Account: Withdraw $200");
		System.out.println("Expected balance: "+ expected);
		System.out.println("Actual balance: "+ actual);
		if (actual==expected){System.out.println("Balance is correct.");}
		
		
		assertThat(actual, is(expected));
	}

	@Test
	public void testWithdrawCheckingAndSavingsAccountPenalty() throws InsufficientFundsException{
		Account cut = new CheckingAccount (150);
		Account cut2 = new SavingsAccount (2000);
		cut.withdraw(200, cut2);
		float actual = cut.getBalance();
		float expected = 0;
	
		float actual2 = cut2.getBalance();
		float expected2 = 1900;
		
		System.out.println("\nChecking & Savings Account Penalty: Withdraw $200");
		System.out.println("Checking expected balance: "+ expected);
		System.out.println("Checking actual balance: "+ actual);
		System.out.println("Savings expected balance: "+ expected2);
		System.out.println("Savings actual balance: "+ actual2);
		
		if (actual==expected && actual2==expected2){System.out.println("Balance is correct.");}
		
		
		assertThat(actual, is(expected));
		assertThat(actual2, is(expected2));
	}
	
	@Test(expected=InsufficientFundsException.class)
	public void testOverdrawFundsCheckingAccount() throws InsufficientFundsException{
		Account cut = new CheckingAccount (150);
		cut.withdraw(250);
	}
	
	@Test(expected=InsufficientFundsException.class)
	public void testOverdrawFundsCheckingAndSavingsAccount() throws InsufficientFundsException{
		Account cut = new CheckingAccount (150);
		Account cut2 = new SavingsAccount (50);
		cut.withdraw(250, cut2);
	}

}
