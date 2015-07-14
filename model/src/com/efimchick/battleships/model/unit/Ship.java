package com.efimchick.battleships.model.unit;

/**
 * Created by efimchick on 14.07.15.
 */
public class Ship extends Unit implements Shooting, Sailing {
    private final ShipType type;

    public Ship(String name, ShipType type) {
        super(name);
        this.type = type;
    }

    @Override
    public Engine getEngine() {
        return type.getEngine();
    }

    @Override
    public Hull getHull() {
        return type.getHull();
    }

    @Override
    public Weapon getWeapon() {
        return type.getWeapon();
    }
}
