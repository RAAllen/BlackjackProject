package com.skilldistillery.iomanager.common;

public class LoseMessage implements Drawable {

	@Override
	public void draw() {
		System.out.print("\u2620\u2639\u2620 You Lost!!! \u2620\u2639\u2620");
	}

}