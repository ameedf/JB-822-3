package ameedf.jb8223.lectures.game.api;

import ameedf.jb8223.lectures.game.weapons.AbstractWeapon;

public interface CanHaveWeapon {
    AbstractWeapon getWeapon();

    void setWeapon(AbstractWeapon weapon);
}
