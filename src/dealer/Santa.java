package dealer;

import consumer.AddictedPlayer;
import consumer.Consumer;
import consumer.Player;

public class Santa implements Dealer {
	private int toys;

	@Override
	public void deal(Consumer[] to) {
	
		System.out.println("toys for everyone ho ho ho ");
		for (Consumer consumer : to) {
			if (consumer instanceof Player ) {
				System.out.println("tack your toy "+ ((Player) consumer).getName());
			}	else {
				System.out.println("tack your toy "+ ((AddictedPlayer) consumer).getName());
			}
		}
		
	}
	
	
}
