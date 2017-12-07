package ameedf.jb8223.assignments.hw04;

public class DrugsDealer extends Person implements Dealer {
	private int drugsAmount = 25;
	private final int oneDoseAmount = 10;
	private AddictedPlayer[] addictedPlayers;

	public DrugsDealer(String id, String name, AddictedPlayer[] addictedPlayers) {
		super(id, name);
		this.addictedPlayers = addictedPlayers;
	}
	
	public Player[] getAddictedPlayers() {
		return addictedPlayers;
	}

	public void setAddictedPlayers(AddictedPlayer[] addictedPlayers) {
		this.addictedPlayers = addictedPlayers;
	}

	public void deal() {
		System.out.println("\nI'm DrugsDealer " + super.getName() + " start to deal...");
		for (Consumer consumer : this.addictedPlayers) {
			if( drugsAmount > oneDoseAmount ) {
				consumer.consume();
				drugsAmount -= oneDoseAmount;
			} else {
				System.out.println("Sorry man, I don't have enough drugs!");
			}
		}
		System.out.println("I'm DrugsDealer " + super.getName() + " end to deal.\n");
	}

	@Override
	public String toString() {
		return "I'm DrugsDealer and " + super.toString() + "!";
	}
	
	
	
}
