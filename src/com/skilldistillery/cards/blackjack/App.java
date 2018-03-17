package com.skilldistillery.cards.blackjack;

import com.skilldistillery.iomanager.common.*;

public class App {
	private Game game = new Game();
	private IOManager ioManager = new SystemIOManager();
	
	public static void main(String[] args) {
		App app = new App();
		app.game.playGame();
		app.shutdown();
	}

	private void shutdown() {
		ioManager.destroy();
	}

	public App() {
		ioManager.init();
	}

}
