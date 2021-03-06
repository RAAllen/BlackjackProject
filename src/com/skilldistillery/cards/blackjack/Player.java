package com.skilldistillery.cards.blackjack;

public class Player {
	private String name;
	private Hand hand;
	
	public Player(String name, Hand hand) {
		this.name = name;
		hand = new Hand();
	}
	
	public Player() {
		hand = new Hand();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name == null || name == "") {
			throw new NullInputException();
		}
		else {			
			this.name = name;
		}
	}

	public Hand getHand() {
		return hand;
	}
	
	public Boolean playerBusts() {
		if(hand.getValueOfHand() > 21) {
			return true;
		}
		
		return false;
	}

	@Override
	public String toString() {
		return name + "'s hand: " + hand;
	}

}
