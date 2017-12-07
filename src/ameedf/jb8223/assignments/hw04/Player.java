package ameedf.jb8223.assignments.hw04;

public class Player extends Person implements Consumer {

		
	public Player(String id, String name) {
		super(id, name);
	}

	@Override
	public String toString() {
		return "I'm Player and " + super.toString() + " ";
	}


	public void consume() {
		System.out.println("Consumer: " + super.getName() + " consume!");
	}
	
}
