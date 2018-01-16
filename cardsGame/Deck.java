package com.asad.cardsGame;

import java.util.Random;

public class Deck {
	private Card[][] deck;

	public Deck() {
		this.deck = new Card[4][13];
		this.deck = buildADeck(this.deck);
	}

	/**
	 * building a Deck of 52 cards
	 * 
	 * @param deck is a 2D array of cards
	 * @return array of 52 cards
	 */
	private Card[][] buildADeck(Card[][] deck) {
		for (int i = 0; i < deck.length; i++) {
			for (int j = 0; j < deck[i].length; j++) {
				deck[i][j] = new Card(i, j);
			}
		}
		return deck;
	}

	/**
	 * building a deal method that return card array that contains n number of random cards for n number of players 
	 * 
	 * @param numberOfCardsForEachPlayer 
	 * @param playersNumber
	 * @return
	 */
	public Card[][] deal(int numberOfCardsForEachPlayer, int playersNumber) {
		Card[][] cardsForNPlayers = new Card[playersNumber][numberOfCardsForEachPlayer];
		boolean[][] cardsIsSelected = new boolean[4][13];
		Random randomNumber = new Random();
		int randomCardSuit = randomNumber.nextInt(4);
		int randomCardRank = randomNumber.nextInt(13);
		for (int i = 0; i < cardsForNPlayers.length; i++) {
			for (int j = 0; j < cardsForNPlayers[i].length; j++) {
				while (cardsIsSelected[randomCardSuit][randomCardRank]) {
					randomCardSuit = randomNumber.nextInt(4);
					randomCardRank = randomNumber.nextInt(12);
				}
				cardsIsSelected[randomCardSuit][randomCardRank] = true;
			cardsForNPlayers[i][j] = new Card(randomCardSuit, randomCardRank);
			}
			
		}
		return cardsForNPlayers;
	}

}
