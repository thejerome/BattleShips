package com.efimchick.battleships.model.map;

import com.efimchick.battleships.model.Direction;
import com.efimchick.battleships.model.Wind;
import com.efimchick.battleships.model.WindPower;
import com.efimchick.battleships.model.game.Position;
import com.efimchick.battleships.model.map.area.Area;
import com.efimchick.battleships.model.map.area.Computer;
import com.efimchick.battleships.model.unit.Engine;
import com.efimchick.battleships.model.unit.Unit;
import com.efimchick.battleships.model.unit.Weapon;
import com.google.common.collect.Table;
import com.google.common.collect.TreeBasedTable;

/**
 * Created by efimchick on 03.10.14.
 */
public class Main {
    public static void main(String[] args) {
        Table<Integer, Integer, Cell> table = TreeBasedTable.create();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                table.put(i, j, new Cell(CellType.SEA));
            }
        }

        for (int i = 6; i < 8; i++) {
            for (int j = 0; j < 3; j++) {
                table.put(i, j, new Cell(CellType.LAND));
            }
        }
        Map map = new Map(table);
        Unit unit = new Unit(new Weapon(4, 5), new Engine());
        unit.engine.engineSpeeds.put(WindPower.BREEZE, 5);
        Position position = new Position();
        position.unitCoordinatesMap.put(unit, new Coordinates(5, 1));


        Area area = Computer.computeMoveArea(map, unit, position, new Wind(Direction.N, WindPower.BREEZE));
        for (Cell cell : area.getCellList()) {
            cell.setCellType(CellType.PORT);
        }

        System.out.println(map);
    }
}
