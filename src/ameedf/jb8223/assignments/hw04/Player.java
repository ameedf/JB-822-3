package ameedf.jb8223.assignments.hw04;

public class Player extends Person implements Consumer {

	public Player(int id, String name) {
		super(id, name);
	}

	@Override
	public void consume(String consumable) {
		System.out.println("Player " + super.getName() + " took his " + consumable + " and ready to play.");
	}
	
}
