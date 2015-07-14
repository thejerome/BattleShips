package com.efimchick.battleships.model.unit;

/**
 * Created by efimchick on 14.07.15.
 */
public class DamageModel {
    private int hits;

    public DamageModel() {
        this.hits = 0;
    }

    public void addHits(int hits) {
        this.hits = this.hits + hits;
    }

    public int getHits() {
        return hits;
    }
}
