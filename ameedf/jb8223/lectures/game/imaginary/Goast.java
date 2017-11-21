package ameedf.jb8223.lectures.game.imaginary;

import ameedf.jb8223.lectures.game.api.Floatable;

public class Goast implements Floatable {
    @Override
    public void floating() {
        System.out.println("I'm floating!");
    }

    @Override
    public void walkThroughWalls() {
        System.out.println("Hey, was that a wall?!");
    }

    @Override
    public void makeScarySounds() {
        System.out.println("MUA-HA-HSAAAA");
    }
}
