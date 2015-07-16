package com.efimchick.battleships.model.map;

import com.efimchick.battleships.model.game.model.Player;
import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * Created by efimchick on 16.07.15.
 */
public class PlayerSeat {
    private final List<Coordinates> fortressSlots;
    private final Coordinates royalPort;
    private Player player;

    public PlayerSeat(List<Coordinates> fortressSlots, Coordinates royalPort) {
        this.fortressSlots = ImmutableList.copyOf(fortressSlots);
        this.royalPort = royalPort;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Coordinates> getFortressSlots() {
        return fortressSlots;
    }

    public Coordinates getRoyalPort() {
        return royalPort;
    }
}
