package edu.umb.cs.cs680;

public class InsufficientFundsException extends Exception {

	private static final long serialVersionUID = -3843223434116335854L;

	public InsufficientFundsException() {}

	public InsufficientFundsException(String message) {

		super(message);
	}

}
