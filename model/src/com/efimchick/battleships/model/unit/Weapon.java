package com.efimchick.battleships.model.unit;

/**
 * Created by efimchick on 03.10.14.
 */
public class Weapon {
    public final int range;
    public final int shots;

    public Weapon(int range, int shots) {
        this.range = range;
        this.shots = shots;
    }

    public int getRange() {
        return range;
    }

    public int getShots() {
        return shots;
    }
}
