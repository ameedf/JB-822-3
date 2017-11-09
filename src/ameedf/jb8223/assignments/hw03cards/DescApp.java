package ameedf.jb8223.assignments.hw03cards;

public class DescApp {

	public static void main(String[] args) {

		Deck game = new Deck();
		System.out.println(game);
		
		int players = 3;
		int cards = 10;
		String mess = "";
		
		Card[][] newDeck = game.deal(cards, players);
		for (int i = 0; i < players ; i++) {
			mess += "\n Player " + (i+1) + ": ";
			for (int j = 0; j < cards; j++) {
				mess += newDeck[j][i] + " ";
			}
		}				
		
		mess += "\n\n";
		
		Card[][] newDeck2 = game.deal(cards, players);
		for (int i = 0; i < players ; i++) {
			mess += "\n Player " + (i+1) + ": ";
			for (int j = 0; j < cards; j++) {
				mess += newDeck2[j][i] + " ";
			}
		}		
		
		System.out.println(mess);
	}
}
