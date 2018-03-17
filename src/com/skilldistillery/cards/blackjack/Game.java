package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;
import com.skilldistillery.iomanager.common.*;

public class Game {
	private IOManager ioManager = new SystemIOManager();
	Deck deck = new Deck();
	Hand playerHand = new Hand(null);
	Hand computerHand = new Hand(null);
	Player player = new Player(null, playerHand);
	Player computer = new Player("Dealer", computerHand);
	
	public void playGame() {
		openingDeal();
		dealAgain();
	}

	public void openingDeal() {
		ioManager.print(new TextWithNewLine("\1F0AC Welcome to the BlackJack Casino! \u1F0DB"));
		ioManager.print(new TextWithNewLine("What's your name?"));
		String theInput = ioManager.getUserInput(new Text(""));
		player.setName(theInput);
		ioManager.print(new TextWithNewLine("Let's play a round " + player.getName() + ".  Good Luck!"));
		deck.shuffle();
		for (int i = 0; i < 2; i++) {
			Card card = deck.dealCard();
			playerHand.addCard(card);
		}
		ArrayList<Card> currentHand = playerHand.getPlayerHand();
		ioManager.print(new TextWithNewLine("Your current hand is " + currentHand));
		Card card = deck.dealCard();
		computerHand.addCard(card);
		ArrayList<Card> currentComputerHand = computerHand.getPlayerHand();
		ioManager.print(new TextWithNewLine("The Dealer is showing a " + currentComputerHand + ". The Dealer also has another facedown card."));
	}
	
	public void dealAgain() {
		
	}

}

////if player is at 21, computer over 21
//if (playerHand.getValueOfHand() == 21 && computerHand.getValueOfHand() > 21) {
//	ioManager.print(new BlackJackMessage());
//	ioManager.print(new WinMessage());
//}
//if (playerHand.getValueOfHand() == 21 && computerHand.getValueOfHand() < 21 && computerHand.getValueOfHand() > 17) {
//	ioManager.print(new BlackJackMessage());
//	ioManager.print(new WinMessage());
//}
////player is under 21, computer over 21
//if (playerHand.getValueOfHand() < 21 && computerHand.getValueOfHand() > 21) {
//	ioManager.print(new WinMessage());
//	
//}
////player is under 21, higher than computer hand, computer is under 17
//if (playerHand.getValueOfHand() >= 21 && playerHand.getValueOfHand() > computerHand.getValueOfHand() && computerHand.getValueOfHand() <= 17) {
//	ioManager.print(new WinMessage());
//	
//}
////player is under 21, higher than computer hand, computer hand is over 17
//if (playerHand.getValueOfHand() >= 21 && playerHand.getValueOfHand() > computerHand.getValueOfHand() && computerHand.getValueOfHand() > 17 && computerHand.getValueOfHand() < 21) {
//	
//}