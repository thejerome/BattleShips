package com.efimchick.battleships.model.map.area;

import com.efimchick.battleships.model.Direction;
import com.efimchick.battleships.model.Wind;
import com.efimchick.battleships.model.WindPower;
import com.efimchick.battleships.model.map.BattleMap;
import com.efimchick.battleships.model.map.CellType;
import com.efimchick.battleships.model.map.Coordinates;
import com.efimchick.battleships.model.unit.Sailing;
import com.efimchick.battleships.model.unit.Shooting;
import com.efimchick.battleships.model.unit.Unit;

import java.util.ArrayList;
import java.util.List;

import static com.efimchick.battleships.model.map.Coordinates.coords;

/**
 * Created by efimchick on 03.10.14.
 */
public class Computer {

    public static <T extends Unit & Shooting> Area computeShootingArea(BattleMap battleMap, T unit) {
        Coordinates selfCoords = battleMap.getCoordsOf(unit);
        List<Coordinates> coordinatesList = new ArrayList<>();
        for (Direction direction : Direction.values()) {
            for (int i = 1; i <= unit.getWeapon().range; i++) {
                int x = selfCoords.x + direction.x * i;
                int y = selfCoords.y + direction.y * i;
                CellType cell = battleMap.getCellAt(x, y);
                if (cell == null || cell == CellType.LAND) {
                    break;
                } else {
                    coordinatesList.add(coords(x, y));
                }
            }
        }
        return new Area(coordinatesList);
    }

    public static <T extends Unit & Shooting> Area computeAdjacentSeaArea(BattleMap battleMap, Coordinates selfCoords) {
        List<Coordinates> coordinatesList = new ArrayList<>();
        for (Direction direction : Direction.values()) {
            int x = selfCoords.x + direction.x * 1;
            int y = selfCoords.y + direction.y * 1;
            CellType cell = battleMap.getCellAt(x, y);
            if (cell == null || cell == CellType.LAND) {
                break;
            } else {
                coordinatesList.add(coords(x, y));
            }

        }
        return new Area(coordinatesList);
    }

    public static <T extends Unit & Sailing> Area computeMoveArea(BattleMap battleMap, T unit, Wind wind) {
        Coordinates startCoords = battleMap.getCoordsOf(unit);
        List<Coordinates> coordinatesList = new ArrayList<>();

        if (wind.getPower() == WindPower.STORM) {
            Coordinates targetCoords = null;
            for (int i = 0; i <= unit.getEngine().engineSpeeds.get(WindPower.STORM); i++) {
                int x = startCoords.x + wind.getDirection().x * i;
                int y = startCoords.y + wind.getDirection().y * i;
                CellType cell = battleMap.getCellAt(x, y);
                if (cell == null || cell == CellType.LAND) {
                    break;
                } else {
                    targetCoords = coords(x, y);
                }
            }
            coordinatesList.add(targetCoords);
        } else {
            coordinatesList.add(startCoords);
            for (Direction direction : Direction.values()) {
                Integer directionSpeed = unit.getEngine().getEngineSpeeds().get(wind.getPower()) - wind.getDirection().countDifference(direction);
                for (int i = 1; i <= directionSpeed; i++) {
                    int x = startCoords.x + direction.x * i;
                    int y = startCoords.y + direction.y * i;
                    CellType cell = battleMap.getCellAt(x, y);
                    if (cell == null || cell == CellType.LAND) {
                        break;
                    } else {
                        coordinatesList.add(coords(x, y));
                    }
                }
            }
        }
        return new Area(coordinatesList);
    }


}
