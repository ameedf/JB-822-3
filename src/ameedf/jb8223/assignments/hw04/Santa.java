package ameedf.jb8223.assignments.hw04;

public class Santa implements Dealer {
	private String name;
	private int giftsAmount = 10;
	private Player[] childrensList;
	
	public Santa(String name, int giftsAmount, Player[] playersList) {
		this.name = name;
		this.giftsAmount = giftsAmount;
		this.childrensList = playersList;
	}
	
	public Player[] getChildrensList() {
		return childrensList;
	}

	public void setChildrensList(Player[] childrensList) {
		this.childrensList = childrensList;
	}

	public void deal() {
		System.out.println("\nI'm giftsDealer " + this.name + " start to deal...");
		for (Consumer consumer : this.childrensList) {
			if( giftsAmount > 0 ) {
				consumer.consume();
				giftsAmount -= 1;
			} else {
				System.out.println("I don't have enough gifts!");
			}
		}
		System.out.println("I'm giftsDealer " + this.name + " finish to deal...");
	}

	@Override
	public String toString() {
		return "My name is " + this.name + "and I'm a Santa!";
	}
	

	
}
