package com.efimchick.battleships.model.game.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by efimchick on 16.07.15.
 */
public class Round {
    private List<Turn> turns;

    public Round(List<Player> players) {
        this.turns = new ArrayList<>(players.size());
    }

    public List<Turn> getTurns() {
        return Collections.unmodifiableList(turns);
    }
}
