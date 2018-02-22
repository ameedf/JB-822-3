package src.ameedf.jb8223.assignments.hw04;

import java.util.Random;

public class Person {
    private final int id;
    private String name;

    public Person(String name) {
        Random newRandomNum = new Random();
        id = newRandomNum.nextInt(10_000);
        this.name = name;
    }

    private int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName() + " " + getId();
    }
}
