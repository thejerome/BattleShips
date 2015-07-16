package com.efimchick.battleships.model.game.model;

import com.efimchick.battleships.model.unit.Shooting;
import com.efimchick.battleships.model.unit.Unit;

/**
 * Created by efimchick on 03.10.14.
 */
public class ShotAction<T extends Unit & Shooting> extends Action<T> {
    private int shots;
    private boolean hit;
    private Unit target;

    public ShotAction(T unit, int shots, boolean hit, Unit taget) {
        super(unit);
        this.shots = shots;
        this.hit = hit;
        this.target = taget;
    }

    public int getShots() {
        return shots;
    }

    public boolean isHit() {
        return hit;
    }

    public Unit getTarget() {
        return target;
    }
}
