package com.efimchick.battleships.model.map;

import com.efimchick.battleships.model.unit.Unit;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by efimchick on 03.10.14.
 */
public class BattleMap {

    private Table<Integer, Integer, CellType> cellTable;
    private BiMap<Unit, Coordinates> unitCoordinatesMap = HashBiMap.create();
    private List<Party> parties = new ArrayList<>();
    private List<Party> defensiveParties = Collections.unmodifiableList(parties);

    public BattleMap(int width, int height) {
        this.cellTable = HashBasedTable.create(width, height);
    }

    public CellType getCellAt(int x, int y) {
        return cellTable.get(x, y);
    }

    public void setCellAt(int x, int y, CellType type) {
        cellTable.put(x, y, type);
    }

    public void addParty(Party party) {
        parties.add(party);
    }

    public List<Party> getParties() {
        return defensiveParties;
    }

    public Coordinates getCoordsOf(Unit unit) {
        return unitCoordinatesMap.get(unit);
    }

    public Unit getUnitAt(Coordinates coordinates) {
        return unitCoordinatesMap.inverse().get(coordinates);
    }

    public void setCoordinatesOf(Unit unit, Coordinates coords) {
        unitCoordinatesMap.forcePut(unit, coords);
    }

    @Override
    public String toString() {
        final int cellSize = 2;
        StringBuilder sb = new StringBuilder();
        sb.append(spaces(cellSize)).append(cellTable.rowKeySet().stream().map(i -> procrust(cellSize, i.toString())).collect(Collectors.joining()));
        for (Integer column : cellTable.columnKeySet()) {
            sb.append("\r\n");
            sb.append(procrust(cellSize, column.toString()));
            sb.append(cellTable.column(column).values().stream().map(cell -> procrust(cellSize, cellTypeImage(cell))).collect(Collectors.joining()));
        }
        return sb.toString();
    }

    private String procrust(int i, String string) {
        if (string.length() < i) {
            return string + spaces(i - string.length());
        } else if (string.length() > i) {
            return string.substring(0, i);
        } else {
            return string;
        }
    }

    private String spaces(int i) {
        String[] spaces = new String[i];
        Arrays.fill(spaces, " ");
        return Arrays.stream(spaces).collect(Collectors.joining());
    }

    private String cellTypeImage(CellType cellType) {
        switch (cellType) {
            case LAND:
                return "IIII";
            case PORT:
                return "= = ";
            case SEA:
                return "~  ~ ";
            default:
                return "";
        }
    }
}
