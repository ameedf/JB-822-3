package ameedf.jb8223.lectures.game.imaginary;

import ameedf.jb8223.lectures.game.api.Flyable;

public class Fairy implements Flyable {
    private final String name;

    public Fairy(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void fly() {
        System.out.println("I'm tinkerbell and I'm flying");
    }

    @Override
    public void land(int x, int y) {
        System.out.println("I'm landed!");
    }
}
