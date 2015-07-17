package com.efimchick.battleships.model.map.area;

import com.efimchick.battleships.model.map.Coordinates;
import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * Created by efimchick on 03.10.14.
 */
public class Area {
    private final List<Coordinates> coordinatesList;

    public Area(List<Coordinates> coordinatesList) {
        this.coordinatesList = ImmutableList.copyOf(coordinatesList);
    }

    public List<Coordinates> getCoordinatesList() {
        return coordinatesList;
    }
}
