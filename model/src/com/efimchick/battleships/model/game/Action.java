package com.efimchick.battleships.model.game;

import com.efimchick.battleships.model.unit.Unit;

/**
 * Created by efimchick on 03.10.14.
 */
public class Action<T extends Unit> {
    Player player;
    T unit;
}
