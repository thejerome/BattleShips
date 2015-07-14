package com.efimchick.battleships.model.unit;

/**
 * Created by efimchick on 14.07.15.
 */
public abstract class Unit {
    private final String name;
    private final DamageModel damageModel;

    public Unit(String name) {
        this.name = name;
        this.damageModel = new DamageModel();
    }

    public String getName() {
        return name;
    }

    public DamageModel getDamageModel() {
        return damageModel;
    }
}
