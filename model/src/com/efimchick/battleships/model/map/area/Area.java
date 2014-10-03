package com.efimchick.battleships.model.map.area;

import com.efimchick.battleships.model.map.Cell;

import java.util.Collections;
import java.util.List;

/**
 * Created by efimchick on 03.10.14.
 */
public class Area {
    private final List<Cell> cellList;

    public Area(List<Cell> cellList) {
        this.cellList = Collections.unmodifiableList(cellList);
    }

    public List<Cell> getCellList() {
        return cellList;
    }
}
