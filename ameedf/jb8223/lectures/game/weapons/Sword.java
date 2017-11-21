package ameedf.jb8223.lectures.game.weapons;

public class Sword extends AbstractWeapon {
    private final int length;

    public Sword(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }
}
