package com.efimchick.battleships.model.unit;

/**
 * Created by efimchick on 14.07.15.
 */
public class ShipType implements Shooting, Sailing {

    public final Engine engine;
    public final Hull hull;
    public final Weapon weapon;
    public final String name;

    public ShipType(Engine engine, Hull hull, Weapon weapon, String name) {
        this.engine = engine;
        this.hull = hull;
        this.weapon = weapon;
        this.name = name;
    }

    @Override
    public Engine getEngine() {
        return engine;
    }

    @Override
    public Hull getHull() {
        return hull;
    }

    @Override
    public Weapon getWeapon() {
        return weapon;
    }

    public String getName() {
        return name;
    }
}
