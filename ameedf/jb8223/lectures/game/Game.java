package ameedf.jb8223.lectures.game;

import ameedf.jb8223.lectures.game.animals.Dog;
import ameedf.jb8223.lectures.game.persons.Prince;
import ameedf.jb8223.lectures.game.weapons.Knife;
import ameedf.jb8223.lectures.game.animals.Lion;
import ameedf.jb8223.lectures.game.api.Flyable;
import ameedf.jb8223.lectures.game.api.Mortal;
import ameedf.jb8223.lectures.game.imaginary.Dragon;
import ameedf.jb8223.lectures.game.imaginary.Fairy;
import ameedf.jb8223.lectures.game.imaginary.Goast;
import ameedf.jb8223.lectures.game.imaginary.Unicorn;
import ameedf.jb8223.lectures.game.persons.Pirate;
import ameedf.jb8223.lectures.game.weapons.Nuclear;
import ameedf.jb8223.lectures.game.weapons.Sword;

public class Game {
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }

    private void start() {
        Dog dog = new Dog("ray");
        Lion lion = new Lion("simba");

        Dragon dragon = new Dragon("Smaug");
        Fairy fairy = new Fairy("tinkerbell");
        Goast casper = new Goast();
        Unicorn twilight = new Unicorn("Twilight");
        Pirate pirate = new Pirate();
        Prince prince = new Prince();

        Knife knife = new Knife();
        knife.setOwner("Rambo");

        Nuclear danger = new Nuclear();
        danger.setOwner("Kim Jong-un");

        Sword sword = new Sword(70);
        sword.setOwner("King Arthur");

        Object[] allEntities = {
                dog, lion, dragon, fairy,
                casper, twilight, pirate, prince,
                knife, danger, sword
        };

        Flyable[] flyables = getFlyables(allEntities);
        for (Flyable flyable : flyables) {
            flyable.fly();
            flyable.land(3, 4);
        }

        Mortal[] mortals = getMortals(allEntities);
        for (Mortal mortal : mortals) {
            if (!mortal.isDead()) {
                mortal.die();
            }
        }
    }

    private Mortal[] getMortals(Object[] allEntities) {
        int count = 0;
        for (Object entity : allEntities) {
            if (entity instanceof Mortal) {
                count++;
            }
        }
        final Mortal[] result = new Mortal[count];
        count = 0;
        for (Object entity : allEntities) {
            if (entity instanceof Mortal) {
                result[count] = (Mortal)entity;
                count++;
            }
        }
        return result;
    }

    private Flyable[] getFlyables(Object[] allEntities) {
        int count = 0;
        for (Object entity : allEntities) {
            if (entity instanceof Flyable) {
                count++;
            }
        }
        final Flyable[] result = new Flyable[count];
        count = 0;
        for (Object entity : allEntities) {
            if (entity instanceof Flyable) {
                result[count] = (Flyable)entity;
                count++;
            }
        }
        return result;
    }
}
