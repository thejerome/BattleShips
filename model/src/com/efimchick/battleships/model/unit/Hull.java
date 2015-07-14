package com.efimchick.battleships.model.unit;

/**
 * Created by efimchick on 14.07.15.
 */
public class Hull {
    public final int hitPoints;

    public Hull(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getHitPoints() {
        return hitPoints;
    }
}
