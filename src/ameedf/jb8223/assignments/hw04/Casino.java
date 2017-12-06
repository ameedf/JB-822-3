package ameedf.jb8223.assignments.hw04;

/**
 * A place where all entities meet.
 * 1. Create an array that will hold at least 3 entities of each type (interface / class)
 * 2. Initialize all entities
 * 3. Create a simple test for the Dealer interface
 * 4. Create a simple test for the Consumer interface
 * <p>
 * You should change the code so the tests will work
 */
public class Casino {
	private Dealer[] dealers = new Dealer[2];
	private Consumer[] consumers = new Consumer[6];
	
	private String[] names = {"Tarmigol", "Josh", "Trevor", "Tommy", "Johnny", "Daniel"};
	
    public void start() {
        initialize();

        testDealerInterface();
        
        testConsumerInterface();

    }

    private void initialize() {
    		Player[] players = new Player[3];
    		for (int i = 0; i < 3; i++) {
				Player p = new Player(i+1, names[i]);
				players[i] = p;
				consumers[i] = p;
			}
    		
    		CardsDealer cardsDealer = new CardsDealer(4, "Black hand");
    		cardsDealer.setPlayers(players);
    		dealers[0] = cardsDealer;
    		
    		AddictedPlayer[] addictedPlayers = new AddictedPlayer[3];
    		for (int i = 0; i < 3; i++) {
    				AddictedPlayer ap = new AddictedPlayer(i+1, names[i+3]);
				addictedPlayers[i] = ap;
				consumers[i+3] = ap;
			}
    		
    		DrugsDealer drugsDealer = new DrugsDealer(9, "Scarface", 29);
    		drugsDealer.setAddictedPlayers(addictedPlayers);
    		dealers[1] = drugsDealer;
    		
    }

    private void testDealerInterface() {
    		for (Dealer dealer : dealers) {
				dealer.deal();
			}
    }
    
    private void testConsumerInterface() {
    		for (Consumer consumer : consumers) {
    			consumer.consume("random substance");
    		}
    }
}
