package ameedf.jb8223.assignments.hw04;

public class Person {
	private final String id;
	private final String name;
	
	public Person(String id, String name) {
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "I'm a Person my name is "+ name + "!";
	}
	
	
	
	
}
