package com.efimchick.battleships.model.game;

import com.efimchick.battleships.model.Wind;
import com.efimchick.battleships.model.map.Cell;
import com.efimchick.battleships.model.unit.Sailing;
import com.efimchick.battleships.model.unit.Unit;

/**
 * Created by efimchick on 03.10.14.
 */
public class MoveAction<T extends Unit & Sailing> extends Action<T> {
    Wind wind;
    Cell cell;
}
