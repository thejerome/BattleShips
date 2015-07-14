package com.efimchick.battleships.model.unit;

/**
 * Created by efimchick on 14.07.15.
 */
public class Fortress extends Unit {
    private final FortressType type;

    public Fortress(String name, FortressType type) {
        super(name);
        this.type = type;
    }
}
