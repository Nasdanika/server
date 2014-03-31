package org.nasdanika.examples.bank;

@SuppressWarnings("serial")
public class BankException extends RuntimeException {


	public BankException(String message) {
		super(message);
	}

	public BankException(Throwable cause) {
		super(cause);
	}

	public BankException(String message, Throwable cause) {
		super(message, cause);
	}

}
