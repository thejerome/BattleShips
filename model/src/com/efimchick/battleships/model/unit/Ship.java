package com.efimchick.battleships.model.unit;

/**
 * Created by efimchick on 14.07.15.
 */
public class Ship extends Unit {
    private final ShipType type;

    public Ship(String name, ShipType type) {
        super(name);
        this.type = type;
    }
}
