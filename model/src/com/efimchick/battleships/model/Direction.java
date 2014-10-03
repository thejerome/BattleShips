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
    public final int x, y;

    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int countDifference(Direction another) {
        int diff;
        int xDiff = Math.abs(this.x - another.x);
        int yDiff = Math.abs(this.y - another.y);

        if (xDiff == 0 && x == 0) {
            return 2 * yDiff;
        } else if (yDiff == 0 && y == 0) {
            return 4;
        } else {
            return xDiff + yDiff;
        }
    }
}
