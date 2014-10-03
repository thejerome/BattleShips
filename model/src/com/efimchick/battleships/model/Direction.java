package com.efimchick.battleships.model;

/**
 * Created by Jerome on 03.10.2014.
 */
public enum Direction {
    N(0, 1),
    NE(1, 1),
    E(1, 0),
    SE(1, -1),
    S(0, -1),
    SW(-1, -1),
    W(-1, 0),
    NW(-1, 1);
    private int x, y;

    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
