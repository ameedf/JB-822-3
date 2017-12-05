package dealer;

import consumer.AddictedPlayer;
import consumer.Consumer;
import extendedClass.Person;

public class DrugsDealer extends Person implements Dealer {

	private AddictedPlayer[] addictedPlayer;
	private int amountOfDrugsInGrams;

	public DrugsDealer(int id, String name, AddictedPlayer[] addictedPlayer, int amountOfDrugsInGrams) {
		super(id, name);
		this.addictedPlayer = addictedPlayer;
		this.amountOfDrugsInGrams = amountOfDrugsInGrams;
	}

	@Override
	public void deal(Consumer[] to) {
		for (AddictedPlayer consumer : (AddictedPlayer[]) to) {
			if (this.amountOfDrugsInGrams >= 10) {
				this.amountOfDrugsInGrams -= 10;
				System.out.println(" its a deal tack the drug " + consumer.getName());
				consumer.consume();
				System.out.println("anount of drugs right Now is "+ this.amountOfDrugsInGrams);
			}

		}

	}

}
