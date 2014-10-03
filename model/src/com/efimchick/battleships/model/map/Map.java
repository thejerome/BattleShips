package com.efimchick.battleships.model.map;

import com.google.common.collect.Table;
import com.google.common.collect.TreeBasedTable;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by efimchick on 03.10.14.
 */
public class Map {

    public Table<Integer, Integer, Cell> cellTable = TreeBasedTable.create();

    public Map(Table<Integer, Integer, Cell> cellTable) {
        this.cellTable = cellTable;
    }

    @Override
    public String toString() {
        final int cellSize = 2;
        StringBuilder sb = new StringBuilder();
        sb.append(spaces(cellSize)).append(cellTable.rowKeySet().stream().map(i -> procrust(cellSize, i.toString())).collect(Collectors.joining()));
        for (Integer column : cellTable.columnKeySet()) {
            sb.append("\r\n");
            sb.append(procrust(cellSize, column.toString()));
            sb.append(cellTable.column(column).values().stream().map(cell -> procrust(cellSize, cellTypeImage(cell.getCellType()))).collect(Collectors.joining()));
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
