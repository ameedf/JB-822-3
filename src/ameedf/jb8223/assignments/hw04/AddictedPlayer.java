package src.ameedf.jb8223.assignments.hw04;

public class AddictedPlayer extends Player implements Consumer {
    private short amountOfDrugsOwned = 0;

    public AddictedPlayer(String name) {
        super(name);
    }

    @Override
    public void consume(boolean drugsSupply) {
        if (!(drugsSupply))  {
            amountOfCardsOwned += 3;
            System.out.println("  " + this.getName() + " got " + amountOfCardsOwned + " cards!");
        }
        else {
            amountOfDrugsOwned += 10;
            System.out.println("  " + this.getName() + " got " + amountOfDrugsOwned + " grams of drugs.");
        }
    }
}
