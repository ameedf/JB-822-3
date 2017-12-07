package ameedf.jb8223.assignments.hw04;

public class CardsDealer extends Person implements Dealer {
	private Player[] playersList;
	
	public CardsDealer(String id, String name, Player[] playersList) {
		super(id, name);
		this.playersList = playersList;
	}

	public void deal() {
		System.out.println("\nI'm CardsDealer " + super.getName() + " start to deal...");
		for (Consumer consumer : this.playersList) {
			consumer.consume();
		}
		System.out.println("I'm CardsDealer " + super.getName() + " end to deal.\n");
	}

	public void setPlayersList(Player[] playersList) {
		this.playersList = playersList;
	}

	@Override
	public String toString() {
		return "I'm CardsDealer and " + super.toString() + "";
	}
	
}
