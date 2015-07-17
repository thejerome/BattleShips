package com.efimchick.battleships.model.map;

/**
 * Created by efimchick on 03.10.14.
 */
public class Coordinates {
    public int x;
    public int y;

    private Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Coordinates coords(int x, int y) {
        return new Coordinates(x, y);
    }
}
