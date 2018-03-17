package com.skilldistillery.cards.blackjack;

import java.util.InputMismatchException;

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
		ioManager.print(new TextWithNewLine("\1F0AC Welcome to the BlackJack Casino! \u1F0DB"));
		ioManager.print(new TextWithNewLine("What's your name?"));
		String theInput = ioManager.getUserInput(new Text(""));
		try {
			player.setName(theInput);
		} catch (NullInputException e) {
			ioManager.print(new TextWithNewLine(
					"I won't play with someone who is so shady they won't even tell me their name..."));
		}
		ioManager.print(new TextWithNewLine("Let's play a round " + player.getName() + ".  Good Luck!"));
		openingDeal();
	}

	public void openingDeal() {
		if (deck.checkDeckSize() < 26) {
			deck.emptyDeck();
			deck.makeDeck();
		}
		deck.shuffle();
		for (int i = 0; i < 2; i++) {
			playerHand.addCard(deck.dealCard());
		}
		displayPlayer();
		if (player.playerBusts() == false) {
			computerHand.addCard(deck.dealCard());
			displayComputer();
			// need to put in next deal method call here
		} else if (player.playerBusts() == true) {
			ioManager.print(new LoseMessage());
			// need to put in restart method call here
		}
	}

	public void playerTurn() {
		while (player.playerBusts() == false) {

		}
	}

	public void hitOrStay() {
		ioManager.print(new TextWithNewLine(player.getName() + " do you want to stay or hit? (Please type h or s)"));
		String hitOrStayValue = ioManager.getUserInput(new Text(""));
		if (hitOrStayValue.equalsIgnoreCase("h")) {
			playerTurn();
		} else if (hitOrStayValue.equalsIgnoreCase("s")) {
			computerTurn();
		} else {
			throw new InputMismatchException();
		}
	}

	public void computerTurn() {
		while (computer.playerBusts() == false) {
			if (computerHand.getValueOfHand() < 17) {
				computerHand.addCard(deck.dealCard());
			} else {

			}
		}
	}
	
	public void playAgain() {
		
	}

	public void compareHands() {
		if (computerHand.getValueOfHand() > playerHand.getValueOfHand()) {
			ioManager.print(new LoseMessage());
			// need to add reset method
		} else if (playerHand.getValueOfHand() > computerHand.getValueOfHand()) {
			ioManager.print(new WinMessage());
			//need to add reset method
		}
	}

	public void displayPlayer() {
		ioManager.print(new TextWithNewLine("Your current hand is " + playerHand.getPlayerHand()));
		ioManager.print(new TextWithNewLine("That adds up to " + playerHand.getValueOfHand()));

	}

	public void displayComputer() {
		ioManager.print(new TextWithNewLine("The Dealer is showing " + computerHand.getPlayerHand()));
		ioManager.print(new TextWithNewLine("That adds up to " + computerHand.getValueOfHand()));
	}

}

// ioManager.print(new BlackJackMessage());
// ioManager.print(new WinMessage());