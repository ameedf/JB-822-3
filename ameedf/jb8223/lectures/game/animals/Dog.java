package ameedf.jb8223.lectures.game.animals;

import ameedf.jb8223.lectures.game.api.Mortal;

public class Dog extends AbstractAnimal implements Mortal{

    public Dog(String name) {
        super(name);
    }

    @Override
    public AnimalType getType() {
        return AnimalType.DOG;
    }

    @Override
    public void die() {
        System.out.println("I'm SOOOO dead!");
    }

    @Override
    public boolean isDead() {
        return false;
    }
}
