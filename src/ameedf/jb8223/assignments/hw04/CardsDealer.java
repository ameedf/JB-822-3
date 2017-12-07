package ameedf.jb8223.assignments.hw04;

public class CardsDealer extends Person implements Dealer {
	
	Player[] players;
	
	public CardsDealer(int id, String name) {
		super(id, name);
	}

	public void setPlayers(Player[] players) {
		this.players = players;
	}

	@Override
	public void deal() {
		for (Player player : players) {
			player.consume("cards");
		}
	}
}
