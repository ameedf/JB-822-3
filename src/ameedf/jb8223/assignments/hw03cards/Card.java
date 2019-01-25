/*
   
   1. class "Card"
	a. Use "char" for rank and suit
	b. Use constants (static final variables)
	c. Use final variables
	d. Create only ONE constructor to generate the card
	e. "toString" will display the representation of a card. For example, "7D", "AH",...

   2. class Deck
	a. Contains 52 cards
	b. Create a method "deal(n, p)" that will RANDOMLY select "n" cards for 
		each one of the "p" players. For example: deal(5, 6) will randomly
		select 30 cards and split them equally (5 for each on of the 6 players).
		The method will return a Card[][] (array of arrays of Card).
*/

package ameedf.jb8223.assignments.hw03cards;

public class Card {
	
	public static final int DIAMONDS = 0; 
	public static final int SPADES  = DIAMONDS + 1;
	public static final int HEARTS  = DIAMONDS + 2;
	public static final int CLUBS   = DIAMONDS + 3;
	
	public static final int TWO   = 0;
	public static final int THREE = TWO + 1;
	public static final int FOUR  = TWO + 2;
	public static final int FIVE  = TWO + 3;
	public static final int SIX   = TWO + 4;
	public static final int SEVEN = TWO + 5;
	public static final int EIGHT = TWO + 6;
	public static final int NINE  = TWO + 7;
	public static final int TEN   = TWO + 8;
	public static final int JACK  = TWO + 9;
	public static final int QUEEN = TWO + 10;
	public static final int KING  = TWO + 11;
	public static final int ACE   = TWO + 12;
	
	//Immutables objects
	private final int suit;
	private final int rank;
	
	public Card(int suit, int rank) {
		this.rank = rank;
		this.suit = suit;
	}

	public int getRank() {
		return rank;
	}

	public int getSuit() {
		return suit;
	}

	@Override
	public String toString() {
		String result = "";
		
		switch(this.suit) {
			case DIAMONDS: result += "D";break;
			case SPADES:   result += "S";break;
			case HEARTS:   result += "H";break;
			case CLUBS:    result += "C";break;
		}
		
		switch(this.rank) {
			case TWO:   result += "2";break;
			case THREE: result += "3";break;
			case FOUR:  result += "4";break;
			case FIVE:  result += "5";break;
			case SIX:   result += "6";break;
			case SEVEN: result += "7";break;
			case EIGHT: result += "8";break;
			case NINE:  result += "9";break;
			case TEN:   result += "10";break;
			case JACK:  result += "J";break;
			case QUEEN: result += "Q";break;
			case KING:  result += "K";break;
			case ACE:   result += "A";break;
		}

		return result;
	}	
}
