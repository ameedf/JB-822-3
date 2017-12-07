package ameedf.jb8223.assignments.hw04;

public abstract class Person {
	private final int id;
	private final String name;
	
	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	
}
