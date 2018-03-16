package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Deck;
import com.skilldistillery.iomanager.common.IOManager;
import com.skilldistillery.iomanager.common.SystemIOManager;
import com.skilldistillery.iomanager.common.TextWithNewLine;

public class App {
	private IOManager ioManager = new SystemIOManager();


	public static void main(String[] args) {
		App app = new App();
		app.run();
	}
	
	public void run() {
		Deck deck = new Deck();
		Hand playerHand = new Hand(null);
		Hand computerHand = new Hand(null);
		Player player = new Player(null, playerHand);
		Player computer = new Player("Dealer", computerHand);
		//if player is at 21, computer over 21
		if (playerHand.getValueOfHand() == 21 && computerHand.getValueOfHand() > 21) {
			ioManager.print(new TextWithNewLine("Blackjack!!!"));
			ioManager.print(new TextWithNewLine("You Win!!!"));
		}
		if (playerHand.getValueOfHand() == 21 && computerHand.getValueOfHand() < 21 && computerHand.getValueOfHand() > 17) {
			ioManager.print(new TextWithNewLine("Blackjack!!!"));
			ioManager.print(new TextWithNewLine("You Win!!!"));
		}
		//player is over 21, computer is less than or equal to 21
		if (playerHand.getValueOfHand() > 21 && computerHand.getValueOfHand() >= 21) {
			ioManager.print(new TextWithNewLine("You Lose!!!"));
		}
		//player is under 21, computer over 21
		if (playerHand.getValueOfHand() < 21 && computerHand.getValueOfHand() > 21) {
			ioManager.print(new TextWithNewLine("You Win!!!"));			
		}
		//player is under 21, higher than computer hand, computer is under 17
		if (playerHand.getValueOfHand() >= 21 && playerHand.getValueOfHand() > computerHand.getValueOfHand() && computerHand.getValueOfHand() <= 17) {
			ioManager.print(new TextWithNewLine("You Win!!!"));
		}
		//player is under 21, higher than computer hand, computer hand is over 17
		if (playerHand.getValueOfHand() >= 21 && playerHand.getValueOfHand() > computerHand.getValueOfHand() && computerHand.getValueOfHand() > 17 && computerHand.getValueOfHand() < 21) {
			
		}

	}
	
//	public String winMessage() {
//		return "You Win!";
//	}

}
