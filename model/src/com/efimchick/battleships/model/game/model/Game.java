package com.efimchick.battleships.model.game.model;

import com.efimchick.battleships.model.map.BattleMap;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by efimchick on 03.10.14.
 */
public class Game {

    private List<Player> players;

    private BattleMap battleMap;
    private List<Round> rounds = new ArrayList<>();

    public Game(BattleMap battleMap, List<Player> players) {
        this.battleMap = battleMap;
        this.players = ImmutableList.copyOf(players);
    }

    public BattleMap getBattleMap() {
        return battleMap;
    }

    public List<Round> getRounds() {
        return rounds;
    }
}
