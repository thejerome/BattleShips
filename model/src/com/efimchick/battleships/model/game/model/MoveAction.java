package com.efimchick.battleships.model.game.model;

import com.efimchick.battleships.model.Wind;
import com.efimchick.battleships.model.map.Cell;
import com.efimchick.battleships.model.unit.Sailing;
import com.efimchick.battleships.model.unit.Unit;

/**
 * Created by efimchick on 03.10.14.
 */
public class MoveAction<T extends Unit & Sailing> extends Action<T> {
    private Wind wind;
    private Cell cell;

    public MoveAction(T unit, Wind wind, Cell cell) {
        super(unit);
        this.wind = wind;
        this.cell = cell;
    }

    public Wind getWind() {
        return wind;
    }

    public Cell getCell() {
        return cell;
    }
}
