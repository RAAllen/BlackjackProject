package com.skilldistillery.cards.blackjack;

public class NullInputException extends RuntimeException {
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	public NullInputException() {
		super();
	}
	
	public NullInputException(String message) {
		super(message);
	}

}
