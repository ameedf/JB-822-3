package ameedf.jb8223.assignments.hw04;

public class Casino {
	
	private 	Player[] playersList;
	private AddictedPlayer[] addictedPlayersList;
	private Player[] childrensList;
	
	private DrugsDealer drugsDealer;
	private CardsDealer cardsDealer;
	private Santa toysDealer;
	
	private final int n = 3;

    public void start() {
    	    	create();
    	    	initialize();
    	    	testDealerInterface();
    	    	testConsumerInterface();
    }
    	    	
    private void create() {
		playersList  = new Player[n];
		cardsDealer = new CardsDealer("CD001","Croupier", playersList);
		
		addictedPlayersList  = new AddictedPlayer[n];
		drugsDealer = new DrugsDealer("DD001", "DarkWeb", addictedPlayersList);
		
		childrensList  = new Player[n];
		toysDealer = new Santa("Klaus", 2, childrensList);
    }
    
    private void initialize() {
	    	playersList[0] = new Player("P001","Billy");
	    	playersList[1] = new Player("P002","Willy");
	    	playersList[2] = new Player("P003","Filly");
	    	cardsDealer.setPlayersList(playersList);
	
	    	addictedPlayersList[0] = new AddictedPlayer("AP011","addicted Hilly");
	    	addictedPlayersList[1] = new AddictedPlayer("AP012","addicted Killy");
	    	addictedPlayersList[2] = new AddictedPlayer("AP013","addicted Lilly");
	    	drugsDealer.setAddictedPlayers(addictedPlayersList);
	    	
	    	childrensList[0] = new Player("T011","children Dilly");
	    	childrensList[1] = addictedPlayersList[1];
	    	childrensList[2] = playersList[1];
	    	toysDealer.setChildrensList(childrensList);
    }
  
    private void testDealerInterface() {
       	System.out.println("\n====================== testDealerInterface ========================\n");
        
    		Dealer[] dealers = new Dealer[n];
	    	dealers[0] = cardsDealer;
	    	dealers[1] = drugsDealer;
	    	dealers[2] = toysDealer;
	    	for (Dealer dealer : dealers) {
			dealer.deal();
		}
    	
    }
    
    private void testConsumerInterface() {
       	System.out.println("\n====================== testConsumerInterface ========================\n");
    	
	    	Consumer[][] consumers = new Consumer[3][n];
	    	consumers[0] = playersList;
	    	consumers[1] = addictedPlayersList;
	    	consumers[2] = childrensList;
	    	
	    	for (int i = 0; i < consumers.length; i++) {
	    		for (int j = 0; j < consumers[i].length; j++) {
				consumers[i][j].consume();
	    		}
		}
    	
    }
    
}
