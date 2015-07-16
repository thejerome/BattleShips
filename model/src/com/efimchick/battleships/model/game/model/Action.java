package com.efimchick.battleships.model.game.model;

import com.efimchick.battleships.model.unit.Unit;

/**
 * Created by efimchick on 03.10.14.
 */
public class Action<T extends Unit> {
    private T unit;

    public Action(T unit) {
        this.unit = unit;
    }

    public T getUnit() {
        return unit;
    }
}
