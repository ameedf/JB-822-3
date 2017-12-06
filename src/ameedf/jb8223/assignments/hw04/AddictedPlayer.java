package ameedf.jb8223.assignments.hw04;

public class AddictedPlayer extends Person implements Consumer {

	public AddictedPlayer(int id, String name) {
		super(id, name);
	}

	@Override
	public void consume(String consumable) {
		System.out.println("Addict " + super.getName() + " has consumed " + consumable + " and went up in smoke.");
	}
}
