package com.efimchick.battleships.model.map.area;

import com.efimchick.battleships.model.Direction;
import com.efimchick.battleships.model.Wind;
import com.efimchick.battleships.model.WindPower;
import com.efimchick.battleships.model.game.Position;
import com.efimchick.battleships.model.map.Cell;
import com.efimchick.battleships.model.map.CellType;
import com.efimchick.battleships.model.map.Coordinates;
import com.efimchick.battleships.model.map.Map;
import com.efimchick.battleships.model.unit.Unit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by efimchick on 03.10.14.
 */
public class Computer {

    public static Area computeShootingArea(Map map, Unit unit, Position position) {
        Coordinates coordinates = position.unitCoordinatesMap.get(unit);


        List<Cell> cellList = new ArrayList<>();
        for (Direction direction : Direction.values()) {
            for (int i = 1; i <= unit.weapon.range; i++) {
                int x = coordinates.x + direction.x * i;
                int y = coordinates.y + direction.y * i;
                Cell cell = map.cellTable.get(x, y);
                if (cell == null || cell.getCellType() == CellType.LAND) {
                    break;
                } else {
                    cellList.add(cell);
                }
            }
        }
        return new Area(cellList);
    }

    public static Area computeMoveArea(Map map, Unit unit, Position position, Wind wind) {
        Coordinates coordinates = position.unitCoordinatesMap.get(unit);
        List<Cell> cellList = new ArrayList<>();

        if (wind.getPower() == WindPower.STORM) {
            Cell targetCell = null;
            for (int i = 0; i <= unit.engine.engineSpeeds.get(WindPower.STORM); i++) {
                int x = coordinates.x + wind.getDirection().x * i;
                int y = coordinates.y + wind.getDirection().y * i;
                Cell cell = map.cellTable.get(x, y);
                if (cell == null || cell.getCellType() == CellType.LAND) {
                    break;
                } else {
                    targetCell = cell;
                }
            }
            cellList.add(targetCell);
        } else {
            cellList.add(map.cellTable.get(coordinates.x, coordinates.y));
            for (Direction direction : Direction.values()) {
                Integer directionSpeed = unit.engine.engineSpeeds.get(wind.getPower()) - wind.getDirection().countDifference(direction);
                for (int i = 1; i <= directionSpeed; i++) {
                    int x = coordinates.x + direction.x * i;
                    int y = coordinates.y + direction.y * i;
                    Cell cell = map.cellTable.get(x, y);
                    if (cell == null || cell.getCellType() == CellType.LAND) {
                        break;
                    } else {
                        cellList.add(cell);
                    }
                }
            }
        }
        return new Area(cellList);
    }


}
