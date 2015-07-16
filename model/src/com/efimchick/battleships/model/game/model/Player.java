package com.efimchick.battleships.model.game.model;

import com.efimchick.battleships.model.unit.Unit;
import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * Created by efimchick on 03.10.14.
 */
public class Player {
    private String name;
    private List<Unit> units;

    public Player(String name, List<Unit> units) {
        this.units = ImmutableList.copyOf(units);
        this.name = name;
    }

    public List<Unit> getUnits() {
        return units;
    }
}
