package com.efimchick.battleships.model;

/**
 * Created by efimchick on 03.10.14.
 */
public class Wind {
    private Direction direction;
    private WindPower power;

    public Wind(Direction direction, WindPower power) {
        this.direction = direction;
        this.power = power;
    }

    public Direction getDirection() {
        return direction;
    }

    public WindPower getPower() {
        return power;
    }

}
