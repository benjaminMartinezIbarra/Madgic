package com.game.madgic;

/**
 * @author benjaminmartinez
 * Date: 2019-05-17
 */

public class Spell {

    Effect effect;
    private boolean isCastable = true;

    public Spell(final Effect effect) {
        this.effect = effect;
    }

    public void resolve() {
        if (this.isCastable()) {
            this.effect.resolve();
        }
    }

    public void destroy() {
        isCastable = false;
    }

    public boolean isCastable() {
        return this.isCastable;
    }

}
