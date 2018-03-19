package com.skilldistillery.cards.blackjack;

import java.util.InputMismatchException;

import com.skilldistillery.cards.common.Deck;
import com.skilldistillery.iomanager.common.*;

public class Game {
	private IOManager ioManager = new SystemIOManager();
	private Deck deck = new Deck();
	private Player player = new Player();
	private Player computer = new Player();
	
	public void playGame() {
		while(true) {
		ioManager.print(new WelcomeMessage());
		String theInput = ioManager.getUserInput(new Text(""));
		try {
			player.setName(theInput);
		} catch (NullInputException e) {
			ioManager.print(new TextWithNewLine(
					"I won't play with someone who is so shady they won't even tell me their name..."));
		}
		ioManager.print(new TextWithNewLine("\nLet's play a round " + player.getName() + ".  Good Luck!"));
		ioManager.print(new TextWithNewLine("* * * * * * * * * * * * * * * * * * * *"));
		openingDeal();
		}
	}

	public void openingDeal() {
		//start of a new hand for player and computer
		if (deck.checkDeckSize() < 46) {
			deck.emptyDeck();
			deck.makeDeck();
		};
		ioManager.print(new Text("" + deck.checkDeckSize()));
		deck.shuffle();
		for (int i = 0; i < 2; i++) {
			player.getHand().addCard(deck.dealCard());
		}
		displayPlayer();
		if (player.playerBusts() == false) {
			computer.getHand().addCard(deck.dealCard());
			displayComputer();
			playerTurn();
		} else if (player.playerBusts() == true) {
			ioManager.print(new LoseMessage());
			playAgain();
		}
	}

	public void playerTurn() {
		//calls the hit or stay while the player is 21 or under
		while (player.playerBusts() == false) {
			hitOrStay();
		}
		if (player.playerBusts() == true) {
			ioManager.print(new LoseMessage());
		}
		playAgain();
	}

	public void hitOrStay() {
		//lets the player choose whether they want another card
		ioManager.print(new TextWithNewLine("\n" + player.getName() + " do you want to stay or hit? (Please type h or s)"));
		String hitOrStayValue = ioManager.getUserInput(new Text(""));
		if (hitOrStayValue.equalsIgnoreCase("h")) {
			player.getHand().addCard(deck.dealCard());
			displayPlayer();
		} else if (hitOrStayValue.equalsIgnoreCase("s")) {
			computerTurn();
		} else {
			throw new InputMismatchException();
		}
	}

	public void computerTurn() {
		//deals another card to the computer if they are under 17 and not busted
		while (computer.playerBusts() == false) {
			if (computer.getHand().getValueOfHand() < 17) {
				computer.getHand().addCard(deck.dealCard());
				displayComputer();
			} else {
				compareHands();
			}
		}
		if (computer.playerBusts() == true) {
			ioManager.print(new WinMessage());
		}
		playAgain();
	}
	
	public void playAgain() {
		//to see if the player wants to play another game after 
		ioManager.print(new TextWithNewLine("\nDo you want to play again " + player.getName() + "? (Please type y or n)"));
		String playAgainValue = ioManager.getUserInput(new Text(""));
		if (playAgainValue.equalsIgnoreCase("y")) {
			computer.getHand().emptyHand();
			player.getHand().emptyHand();
			openingDeal();
		} else if (playAgainValue.equalsIgnoreCase("n")) {
			ioManager.destroy();
		} else {
			throw new InputMismatchException();
		}
	}

	public void compareHands() {
		//to compare hands and get a winner for times when both players retire with a score of under 21
		if (computer.getHand().getValueOfHand() > player.getHand().getValueOfHand()) {
			ioManager.print(new LoseMessage());
			playAgain();
		} else if (player.getHand().getValueOfHand() > computer.getHand().getValueOfHand()) {
			ioManager.print(new WinMessage());
			playAgain();
		} else if (player.getHand().getValueOfHand() == computer.getHand().getValueOfHand()) {
			ioManager.print(new DrawMessage());
			playAgain();
		}
	}

	public void displayPlayer() {
		//displays user score and hand
		ioManager.print(new TextWithNewLine("\nYour current hand is " + player.getHand().getPlayerHand()));
		ioManager.print(new TextWithNewLine("That adds up to " + player.getHand().getValueOfHand()));

	}

	public void displayComputer() {
		//displays computer hand and score
		ioManager.print(new TextWithNewLine("\nThe Dealer is showing " + computer.getHand().getPlayerHand()));
		ioManager.print(new TextWithNewLine("That adds up to " + computer.getHand().getValueOfHand()));
	}

}