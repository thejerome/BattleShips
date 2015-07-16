package com.efimchick.battleships.model.game.order;

import com.efimchick.battleships.model.game.model.Player;
import com.efimchick.battleships.model.map.BattleMap;
import com.efimchick.battleships.model.map.PlayerSeat;
import com.efimchick.battleships.model.unit.*;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import java.util.List;

import static com.efimchick.battleships.model.WindPower.*;
import static com.efimchick.battleships.model.map.CellType.LAND;
import static com.efimchick.battleships.model.map.CellType.SEA;
import static com.efimchick.battleships.model.map.Coordinates.coords;

/**
 * Created by efimchick on 16.07.15.
 */
public class Main {
    public static void main(String[] args) {
        Weapon largeBattery = new Weapon(6, 3);
        Weapon mediumBattery = new Weapon(5, 2);
        Weapon smallBattery = new Weapon(4, 1);

        Hull largeHull = new Hull(7);
        Hull mediumHull = new Hull(5);
        Hull smallHull = new Hull(3);

        WallStrength thickWalls = new WallStrength(7);
        WallStrength normalWalls = new WallStrength(5);

        Engine fastSails = new Engine(ImmutableMap.of(BREEZE, 7, CALM, 0, STORM, 2));
        Engine normalSailsAndOars = new Engine(ImmutableMap.of(BREEZE, 5, CALM, 1, STORM, 1));
        Engine slowSteam = new Engine(ImmutableMap.of(BREEZE, 4, CALM, 3, STORM, 2));

        FortressType greatFort = new FortressType("Great Fort", largeBattery, thickWalls);
        FortressType fort = new FortressType("Fort", mediumBattery, normalWalls);

        ShipType dreadnaught = new ShipType("Dreadnaught", largeBattery, largeHull, slowSteam);
        ShipType clipper = new ShipType("Clipper", mediumBattery, smallHull, fastSails);
        ShipType galley = new ShipType("Galley", smallBattery, mediumHull, normalSailsAndOars);


        Player jerome = new Player(
                "Jerome",
                ImmutableList.of(
                        new Fortress("Sevastopol", greatFort),
                        new Fortress("Balaklava", fort),
                        new Ship("Camilla1", dreadnaught),
                        new Ship("Camilla2", clipper),
                        new Ship("Camilla3", clipper),
                        new Ship("Camilla4", galley),
                        new Ship("Camilla5", galley)
                )
        );

        Player peterBlood = new Player(
                "Peter Blood",
                ImmutableList.of(
                        new Fortress("Tortuga", greatFort),
                        new Fortress("Barbados", fort),
                        new Ship("Arabella1", dreadnaught),
                        new Ship("Arabella2", clipper),
                        new Ship("Arabella3", clipper),
                        new Ship("Arabella4", galley),
                        new Ship("Arabella5", galley)
                )
        );

        int width = 30;
        int height = 30;
        BattleMap battleMap = new BattleMap(width, height);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                battleMap.setCellAt(i, j, SEA);
            }
        }

        for (int i = 10; i < 15; i++) {
            for (int j = 15; j < 20; j++) {
                battleMap.setCellAt(i, j, LAND);
                battleMap.setCellAt(j, i, LAND);
            }
        }

        battleMap.addPlayerSeat(new PlayerSeat(
                ImmutableList.of(coords(7, 8), coords(5, 4))
                , coords(0, 0)
        ));
        battleMap.addPlayerSeat(new PlayerSeat(
                ImmutableList.of(coords(23, 24), coords(25, 24))
                , coords(29, 29)
        ));


        List<Player> players = ImmutableList.of(jerome, peterBlood);


    }
}
