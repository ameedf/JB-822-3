package com.asad.cardsGame;

public class CardGameApplication {

	public static void main(String[] args) {
		Deck deck = new Deck();

		Card[][] deal = new Card[4][6];
		deal = deck.deal(5, 6);
		for (Card[] cards : deal) {
			for (Card card : cards) {
				System.out.print(card+" ");
			}
			System.out.println();
		}
	}

}
