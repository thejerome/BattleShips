package com.efimchick.battleships.model.game;

import com.efimchick.battleships.model.map.Coordinates;
import com.efimchick.battleships.model.unit.Unit;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by efimchick on 03.10.14.
 */
public class Position {
    public Map<Unit, Coordinates> unitCoordinatesMap = new HashMap<>();
}
