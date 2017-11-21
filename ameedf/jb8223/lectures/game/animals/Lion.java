package ameedf.jb8223.lectures.game.animals;

import ameedf.jb8223.lectures.game.api.Mortal;

public class Lion extends AbstractAnimal implements Mortal{

    public Lion(String name) {
        super(name);
    }

    @Override
    public AnimalType getType() {
        return AnimalType.LION;
    }

    @Override
    public void die() {
        System.out.println("I'm a dead lion!");
    }

    @Override
    public boolean isDead() {
        return false;
    }
}
