package com.efimchick.battleships.model.unit;

/**
 * Created by efimchick on 14.07.15.
 */
public class Fortress extends Unit implements Shooting, Building {
    private final FortressType type;

    public Fortress(String name, FortressType type) {
        super(name);
        this.type = type;
    }

    public FortressType getType() {
        return type;
    }

    @Override
    public WallStrength getWallStrength() {
        return type.getWallStrength();
    }

    @Override
    public Weapon getWeapon() {
        return type.getWeapon();
    }
}
