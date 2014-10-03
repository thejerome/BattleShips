package com.efimchick.battleships.model.map;

/**
 * Created by efimchick on 03.10.14.
 */
public class Cell {
    private CellType cellType;

    public Cell(CellType cellType) {
        this.cellType = cellType;
    }

    public CellType getCellType() {
        return cellType;
    }

    public void setCellType(CellType cellType) {
        this.cellType = cellType;
    }
}
