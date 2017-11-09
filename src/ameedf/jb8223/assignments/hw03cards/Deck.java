package ameedf.jb8223.assignments.hw03cards;
import java.util.Random;

import hw.oop.cards.Card;

public class Deck {
	private static final int SUIT_SIZE = 4;
	private static final int RANK_SIZE = 13;
	private static final Card[][] cardDeck = new Card[SUIT_SIZE][RANK_SIZE];
	
	public Deck() {
		for(int suit = 0; suit< SUIT_SIZE; suit++) {
			for (int rank = 0; rank < RANK_SIZE; rank++) {
				cardDeck[suit][rank] = new Card(suit ,rank); 
			}
		}
	}
	
	public Card[][] deal(int cards, int players) {
		int[][] cardDeckUsed = new int[SUIT_SIZE][RANK_SIZE];
		Card[][] gameDeck = new Card[cards][players];
		Random rn = new Random();
		int randomRank,randomSuit;
		for (int i = 0; i < cards; i++) {
			for (int j = 0; j < players; j++) {
				do {
					randomSuit = rn.nextInt(SUIT_SIZE);
					randomRank = rn.nextInt(RANK_SIZE);					
					if( cardDeckUsed[randomSuit][randomRank] != 1) {
						gameDeck[i][j] = cardDeck[randomSuit][randomRank];
						cardDeckUsed[randomSuit][randomRank] = 1;
					}
				} while(gameDeck[i][j] == null);
				//System.out.println("--> i=" +i +" j="+ j+ " =" + gameDeck[i][j]);
			}
		}		
		return gameDeck;
	}
	
	
	@Override
	public String toString() {
		String result = "";
		
		for(int suit = 0; suit< SUIT_SIZE; suit++) {
			for (int rank = 0; rank < RANK_SIZE; rank++) {
				result += " " + cardDeck[suit][rank].toString();
			}
			result += "\n";
		}
		
		return result;
	}


}
