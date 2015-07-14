package com.efimchick.battleships.model.unit;

/**
 * Created by efimchick on 14.07.15.
 */
public class FortressType implements Shooting, Building {
    public final Weapon weapon;
    public final WallStrength wallStrength;

    public FortressType(Weapon weapon, WallStrength wallStrength) {
        this.weapon = weapon;
        this.wallStrength = wallStrength;
    }

    @Override
    public Weapon getWeapon() {
        return weapon;
    }

    @Override
    public WallStrength getWallStrength() {
        return wallStrength;
    }
}
