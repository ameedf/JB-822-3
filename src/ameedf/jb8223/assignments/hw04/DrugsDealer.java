package src.ameedf.jb8223.assignments.hw04;

/* Has a list of AddictedPlayers to deal to, and a specific amount of drugs to deal (in grams).
Each addict will consume 10g each time. When there are no drugs to deal, the dealing action will do nothing */
public class DrugsDealer extends Person implements Dealer {
    private short amountOfDrugs = 250;

    public DrugsDealer(String name) {
        super(name);
    }

    @Override
    public void deal(Object[] consumers) {
        System.out.println("\nDrugs dealer deals...");
        for (Object entity : consumers) {
            if (entity instanceof AddictedPlayer) {
                if (amountOfDrugs > 0) {
                    amountOfDrugs -= 10;
                    ((AddictedPlayer) entity).consume(true);
                    System.out.println("Drug dealer left with " + amountOfDrugs + " grams out of 250.");
                }
            }
        }
    }
}
