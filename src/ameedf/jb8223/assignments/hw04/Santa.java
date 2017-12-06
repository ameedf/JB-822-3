package ameedf.jb8223.assignments.hw04;

public class Santa extends Person implements Dealer {
	private int amountOfToys;
	
	public Santa(int id, String name, int amountOfToys) {
		super(id, name);
		this.amountOfToys = amountOfToys;
	}

	@Override
	public void deal() {
		if (amountOfToys > 0) {
			System.out.println("Dealing toys, ho-ho-ho!");
		} else {
			System.out.println("Christmass is over, go home!");
		}
	}
}
