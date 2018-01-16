package com.asad.cardsGame;

public class Card {
	public static final int DIAMOND = 0;
	public static final int CLUBS = DIAMOND + 1;
	public static final int SPADES = CLUBS + 1;
	public static final int HEARTS = SPADES + 1;

	public static final int TWO = 0;
	public static final int THREE = TWO + 1;
	public static final int FOUR = THREE + 1;
	public static final int FIVE = FOUR + 1;
	public static final int SIX = FIVE + 1;
	public static final int SEVEN = SIX + 1;
	public static final int EIGHT = SEVEN + 1;
	public static final int NINE = EIGHT + 1;
	public static final int TEN = NINE + 1;
	public static final int JACK = TEN + 1;
	public static final int QUEEN = JACK + 1;
	public static final int KING = QUEEN + 1;
	public static final int ACE = KING + 1;
	
	private final int SUIT;
	private final int RANK;
	public Card(int sUIT, int rANK) {
		
		SUIT = sUIT;
		RANK = rANK;
	}
	
	
	public int getSUIT() {
		return SUIT;
	}


	public int getRANK() {
		return RANK;
	}

    /**
     * return a string that contain the first letter of the suit and the rank of the card
     */
	@Override
	public String toString() {
	
		String result ="";
		if(this.SUIT==Card.DIAMOND) {
			result+="D";
		}else if(this.SUIT== Card.CLUBS) {
			result+="C";
		}else if(this.SUIT == Card.HEARTS) {
			result+="H";
		}else if(this.SUIT== Card.SPADES) {
			result+="S";
		}
			
		if(this.RANK== Card.TWO) {
			result+="2";
		}else if(this.RANK== Card.THREE) {
			result+="3";
		}else if(this.RANK== Card.FOUR) {
			result+="4";
		}else if(this.RANK== Card.FIVE) {
			result+="5";
		}else if(this.RANK== Card.SIX) {
			result+="6";
		}else if(this.RANK== Card.SEVEN) {
			result+="7";
		}else if(this.RANK== Card.EIGHT) {
			result+="8";
		}else if(this.RANK== Card.NINE) {
			result+="9";
		}else if(this.RANK== Card.TEN) {
			result+="10";
		}else if(this.RANK== Card.JACK) {
			result+="J";
		}else if(this.RANK== Card.QUEEN) {
			result+="Q";
		}else if(this.RANK== Card.KING) {
			result+="K";
		} else {
			result+="A";
		}
		return result;
	}
	
	
}
