package src.ameedf.jb8223.assignments.hw04;

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

    private Person person1, person2, person3;
    private Player player1, player2, player3;
    private AddictedPlayer addictedPlayer1, addictedPlayer2, addictedPlayer3;
    private CardsDealer cardsDealer;
    private DrugsDealer drugsDealer;
    private Santa santaClaus;

    private Object[] consumersList;
    private Object[] dealersList;

    public void start() {
        System.out.println("Welcome to the Casino!");

        create();
        initialize();
        testDealerInterface();
        //my deal() already calls consume(), so next method not needed
        //testConsumerInterface();
    }

    private void create() {
        //create Consumers list
        consumersList = new Object[] {
                player1, player2, player3,
                addictedPlayer1, addictedPlayer2, addictedPlayer3,
                person1, person2, person3
        };

        //create Dealers list
        dealersList = new Object[] {
                cardsDealer, drugsDealer, santaClaus
        };
    }

    private void initialize() {
        //initialize Consumers (toys, cards, cards & drugs)
        person1 = new Person("Adam");
        person2 = new Person("Eva");
        person3 = new Person("Kain");
        consumersList[0] = person1;
        consumersList[1] = person2;
        consumersList[2] = person3;

        player1 = new Player("Mark");
        player2 = new Player("Jemie");
        player3 = new Player("Steve");
        consumersList[3] = player1;
        consumersList[4] = player2;
        consumersList[5] = player3;

        addictedPlayer1 = new AddictedPlayer("Bob");
        addictedPlayer2 = new AddictedPlayer("Elane");
        addictedPlayer3 = new AddictedPlayer("David");
        consumersList[6] = addictedPlayer1;
        consumersList[7] = addictedPlayer2;
        consumersList[8] = addictedPlayer3;

        //initialize Dealers (toys, cards, drugs)
        cardsDealer = new CardsDealer("Sam");
        drugsDealer = new DrugsDealer("Johnny");
        santaClaus = new Santa();
        dealersList[0] = cardsDealer;
        dealersList[1] = drugsDealer;
        dealersList[2] = santaClaus;
    }

    private void testDealerInterface() {
        System.out.println("\nTesting the Dealer & Consumer interface:");
        for (Object entity : dealersList) {
            ((Dealer) entity).deal(consumersList);
        }
    }
}
