package casino;

import consumer.AddictedPlayer;
import consumer.Consumer;
import consumer.Player;
import dealer.CardsDealer;
import dealer.DrugsDealer;
import dealer.Santa;

public class Casino {
	public static final int maxNumberOfPlayers = 4;

	public void start() {

		Player player1 = new Player(1, "sam");
		Player player2 = new Player(2, "johan");
		Player player3 = new Player(3, "dok");
		Player player4 = new Player(4, "jacke");

		AddictedPlayer addictedPlayer1 = new AddictedPlayer(1, "hamed");
		AddictedPlayer addictedPlayer2 = new AddictedPlayer(2, "saleh");
		AddictedPlayer addictedPlayer3 = new AddictedPlayer(3, "amer");
		AddictedPlayer addictedPlayer4 = new AddictedPlayer(4, "ameer");

		Consumer[] consumers = { player1, player2, player3, player4, addictedPlayer1, addictedPlayer2, addictedPlayer3,
				addictedPlayer4 };

		Consumer[] players = playerDefine(consumers, (Consumer) (new Player(1, "xxx")));
		CardsDealer cardsDealer = new CardsDealer(0, "aizen", (Player[]) players);
		cardsDealer.deal(players);
		System.out.println("-----------------------------------------------------------------------------");
		Consumer[] addictedPlayers = playerDefine(consumers, (Consumer) (new AddictedPlayer(1, "xxx")));
		DrugsDealer drugsDealer = new DrugsDealer(2, "nomel", (AddictedPlayer[]) addictedPlayers, 40);
		drugsDealer.deal(addictedPlayers);
		System.out.println("-----------------------------------------------------------------------------");
		Santa santa = new Santa();
		santa.deal(consumers);
		
	}
	
	
	
	
	

	private Consumer[] playerDefine(Consumer[] conumers, Consumer consumerType) {
		Player[] players = new Player[maxNumberOfPlayers];
		AddictedPlayer[] addictedPlayers = new AddictedPlayer[maxNumberOfPlayers];
		int playerCounter = 0;
		int addictedPlayerCounter = 0;
		for (Consumer consumer : conumers) {
			if (consumer != null && consumer instanceof Player) {
				players[playerCounter] = (Player) consumer;
				playerCounter++;
			} else {
				addictedPlayers[addictedPlayerCounter] = (AddictedPlayer) consumer;
				addictedPlayerCounter++;
			}
		}
		if (consumerType instanceof Player) {
			return players;
		} else {
			return addictedPlayers;
		}

	}
}
