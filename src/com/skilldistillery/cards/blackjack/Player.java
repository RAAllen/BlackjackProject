package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public class Player {
	Deck deck = new Deck();
	ArrayList<Card> playerHand = new ArrayList<>();

	public void addCard(Card card) {
		Card cardToAdd = deck.dealCard();
		playerHand.add(cardToAdd);
	}
	
	public ArrayList<Card> getPlayerHand() {
		return playerHand;
	}
	
	public int getValueOfPlayerHand() {
		int totalHandValue = 0;
		for (int i = 0; i < playerHand.size(); i++) {
			Card card = playerHand.get(i);
			totalHandValue += card.getValue();
		}
		return totalHandValue;
	}
}
