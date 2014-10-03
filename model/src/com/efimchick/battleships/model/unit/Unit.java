package com.efimchick.battleships.model.unit;


/**
 * Created by efimchick on 03.10.14.
 */
public class Unit {
    public Weapon weapon;
    public Engine engine;

    public Unit(Weapon weapon, Engine engine) {
        this.weapon = weapon;
        this.engine = engine;
    }
}
