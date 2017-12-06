package ameedf.jb8223.assignments.hw04;

public class DrugsDealer extends Person implements Dealer {
	AddictedPlayer[] addictedPlayers;
	private int amountOfDrugs;
	
	public DrugsDealer(int id, String name, int drugsToDeal) {
		super(id, name);
		this.amountOfDrugs = drugsToDeal;
	}
	
	
	
	public void setAddictedPlayers(AddictedPlayer[] addictedPlayers) {
		this.addictedPlayers = addictedPlayers;
	}



	@Override
	public void deal() {
		for (AddictedPlayer addictedPlayer : addictedPlayers) {
			if (amountOfDrugs >= 10) {
				addictedPlayer.consume("drug");
				amountOfDrugs -= 10;				
			} else {
				System.out.println("No more drugs today! Sorry, " + addictedPlayer.getName());
			}
		}
	}
}
