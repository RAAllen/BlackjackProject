package com.skilldistillery.cards.common;

public enum Suit {
	HEARTS("Hearts"), SPADES("Spades"), CLUBS("Clubs"), DIAMONDS("Diamonds");

	final private String name;

	Suit(String n) {
		name = n;
	}

	@Override
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}

}