package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;

import com.skilldistillery.cards.common.Card;

public class Hand {
	private ArrayList<Card> hand;
	
	public Hand(ArrayList<Card> hand) {
		this.hand = hand;
	}

	public void addCard(Card cardToAdd) {
		hand.add(cardToAdd);
	}
	
	public ArrayList<Card> getPlayerHand() {
		return hand;
	}
	
	public void emptyHand() {
		hand.clear();
	}
	
	public int getValueOfHand() {
		int totalHandValue = 0;
		for (int i = 0; i < hand.size(); i++) {
			Card card = hand.get(i);
			totalHandValue += card.getValue();
		}
		return totalHandValue;
	}

	@Override
	public String toString() {
		return "[" + hand + "]";
	}
	
}
