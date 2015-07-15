package com.efimchick.battleships.model.game;

import com.efimchick.battleships.model.unit.Shooting;
import com.efimchick.battleships.model.unit.Unit;

/**
 * Created by efimchick on 03.10.14.
 */
public class ShotAction<T extends Unit & Shooting> extends Action<T> {
    int shots;
    boolean hit;
    Unit taget;
}
