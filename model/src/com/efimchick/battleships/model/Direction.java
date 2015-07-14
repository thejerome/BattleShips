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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int countDifference(Direction another) {
        if (this.x == another.x && this.y == another.y) {
            return 0;
        }

        if ((this.x == 0 && this.x == another.x && this.y == -another.y) ||
                (this.y == 0 && this.y == another.y && this.x == -another.x)) {
            return 4;
        }

        int xDiff = Math.abs(this.x - another.x);
        int yDiff = Math.abs(this.y - another.y);
        return xDiff + yDiff;
    }
}
