package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Deck;
import com.skilldistillery.iomanager.common.*;

public class Game {
	private IOManager ioManager = new SystemIOManager();
	
	public void playGame() {
		
		Deck deck = new Deck();
		Hand playerHand = new Hand(null);
		Hand computerHand = new Hand(null);
		Player player = new Player(null, playerHand);
		Player computer = new Player("Dealer", computerHand);
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