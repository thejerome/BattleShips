package com.efimchick.battleships.model.game.model;

import com.efimchick.battleships.model.map.Coordinates;
import com.efimchick.battleships.model.unit.Fortress;
import com.efimchick.battleships.model.unit.Ship;
import com.efimchick.battleships.model.unit.Unit;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by efimchick on 03.10.14.
 */
public class Player {
    private String name;
    private List<Unit> units;
    private List<Unit> forts;
    private List<Unit> ships;
    private List<Coordinates> ports = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public List<Unit> getUnits() {
        return units;
    }

    public void setUnits(List<Unit> units) {
        this.units = ImmutableList.copyOf(units);
        this.forts = Collections.unmodifiableList(units.stream().filter(u -> u instanceof Fortress).collect(toList()));
        this.ships = Collections.unmodifiableList(units.stream().filter(u -> u instanceof Ship).collect(toList()));
    }

    public List<Unit> getForts() {
        return forts;
    }

    public List<Unit> getShips() {
        return ships;
    }

    public String getName() {
        return name;
    }

    public List<Coordinates> getPorts() {
        return ports;
    }

    public void addPorts(Coordinates... coords) {
        for (Coordinates coord : coords) {
            ports.add(coord);
        }
    }
}
