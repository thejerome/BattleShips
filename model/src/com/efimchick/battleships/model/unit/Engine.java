package com.efimchick.battleships.model.unit;

import com.efimchick.battleships.model.WindPower;
import com.google.common.collect.ImmutableMap;

import java.util.Map;

/**
 * Created by efimchick on 03.10.14.
 */
public class Engine {
    public final Map<WindPower, Integer> engineSpeeds;

    public Engine(Map<WindPower, Integer> engineSpeeds) {
        this.engineSpeeds = ImmutableMap.copyOf(engineSpeeds);
    }

    public Map<WindPower, Integer> getEngineSpeeds() {
        return engineSpeeds;
    }
}
