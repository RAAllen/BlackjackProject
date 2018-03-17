package com.skilldistillery.cards.blackjack;

public class Player {
	private String name;
	private Hand hand;
	
	public Player(String name, Hand hand) {
		this.name = name;
		this.hand = hand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
