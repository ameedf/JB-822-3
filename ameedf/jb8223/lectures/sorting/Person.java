package ameedf.jb8223.lectures.sorting;

public abstract class Person {
    private final String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
