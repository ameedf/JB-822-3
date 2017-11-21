package ameedf.jb8223.lectures.game.imaginary;

import ameedf.jb8223.lectures.game.animals.AbstractAnimal;
import ameedf.jb8223.lectures.game.animals.AnimalType;
import ameedf.jb8223.lectures.game.api.Flyable;
import ameedf.jb8223.lectures.game.api.Mortal;

public class Dragon extends AbstractAnimal implements Mortal, Flyable {

    public Dragon(String name) {
        super(name);
    }

    @Override
    public AnimalType getType() {
        return AnimalType.DRAGON;
    }

    @Override
    public void die() {
        System.out.println("I'm dead!");
    }

    @Override
    public boolean isDead() {
        return false;
    }

    @Override
    public void fly() {
        System.out.println("Look at me, i'm flying! :-)");
    }

    @Override
    public void land(int x, int y) {
        System.out.println("Landed at " + x + ", " + y);
    }
}
