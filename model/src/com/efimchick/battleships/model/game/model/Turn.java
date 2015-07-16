package com.efimchick.battleships.model.game.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by efimchick on 03.10.14.
 */
public class Turn {
    private Player player;
    private List<Action> actionList = new LinkedList<>();

    public Turn(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public List<Action> getActionList() {
        return Collections.unmodifiableList(actionList);
    }
}
