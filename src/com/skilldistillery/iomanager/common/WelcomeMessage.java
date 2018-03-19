package com.skilldistillery.iomanager.common;

public class WelcomeMessage implements Drawable {

	@Override
	public void draw() {		
		System.out.println("\u2660 \u2663 \u2665 \u2666 \u2660 \u2663 \u2665 \u2666 \u2660 \u2663 \u2665 \u2666 \u2660 \u2663 \u2665 \u2666 \u2660 \u2663 \u2665 \u2666");
		System.out.println("\u2663                                     \u2665");
		System.out.println("\u2665   Welcome to the BlackJack Casino!  \u2663");
		System.out.println("\u2666                                     \u2660");
		System.out.println("\u2660 \u2663 \u2665 \u2666 \u2660 \u2663 \u2665 \u2666 \u2660 \u2663 \u2665 \u2666 \u2660 \u2663 \u2665 \u2666 \u2660 \u2663 \u2665 \u2666");
		System.out.println("");
		System.out.println("\u2660 What's your name?");
	}

}