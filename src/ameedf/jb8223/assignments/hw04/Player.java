package src.ameedf.jb8223.assignments.hw04;

//consumes the cards dealing
public class Player extends Person implements Consumer {
    short amountOfCardsOwned = 0;

    public Player(String name) {
        super(name);
    }

    @Override
    public void consume(boolean drugsSupply) {
        amountOfCardsOwned += 3;
        System.out.println("  " + this.getName() + " got " + amountOfCardsOwned + " cards!");
    }
}
