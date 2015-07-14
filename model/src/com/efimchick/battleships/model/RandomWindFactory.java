package com.efimchick.battleships.model;

import java.util.Random;

/**
 * Created by efimchick on 03.10.14.
 */
public class RandomWindFactory implements WindFactory {

    private Random random = new Random();

    @Override
    public Wind getWind() {
        Direction direction = Direction.values()[random.nextInt(Direction.values().length)];
        WindPower power = WindPower.values()[random.nextInt(WindPower.values().length)];
        return new Wind(direction, power);
    }
}
