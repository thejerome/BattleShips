package com.efimchick.battleships.model.map;

import com.efimchick.battleships.model.Direction;
import com.efimchick.battleships.model.Wind;
import com.efimchick.battleships.model.WindPower;
import com.efimchick.battleships.model.game.Position;
import com.efimchick.battleships.model.map.area.Area;
import com.efimchick.battleships.model.map.area.Computer;
import com.efimchick.battleships.model.unit.*;
import com.google.common.collect.ImmutableMap;
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
        Ship ship = new Ship("Catalina",
                new ShipType(
                        new Engine(ImmutableMap.of(WindPower.BREEZE, 5, WindPower.CALM, 2, WindPower.STORM, 3)),
                        new Hull(7),
                        new Weapon(4, 5),
                        "Frigate")
        );
        Position position = new Position();
        position.unitCoordinatesMap.put(ship, new Coordinates(5, 1));


        Area area = Computer.computeMoveArea(map, ship, position, new Wind(Direction.N, WindPower.BREEZE));
        for (Cell cell : area.getCellList()) {
            cell.setCellType(CellType.PORT);
        }

        System.out.println(map);
    }
}
