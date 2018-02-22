package src.ameedf.jb8223.assignments.hw04;

/*Has a limited number of toys to deal.
When there are no toys to deal, the dealing action will do nothing  */
public class Santa implements Dealer {
    private int numOfToys = 10;

    @Override
    public void deal(Object[] consumers) {
        System.out.println("\nSanta deals...");
        for (Object entity : consumers) {
            if (!(entity instanceof Player)) {
                if (numOfToys > 0) {
                    numOfToys--;
                    System.out.println("  Ho Ho Ho! A present for " + ((Person) entity).getName() +
                            "! Come and get it, only " + numOfToys + " left!");
                }
            }
        }
    }
}
