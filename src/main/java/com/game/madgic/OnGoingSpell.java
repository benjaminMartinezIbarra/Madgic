package com.game.madgic;

/**
 * @author benjaminmartinez
 * Date: 2019-05-19
 */

public class OnGoingSpell<T> {

    private Effect<T> effect;
    private T target;

    public OnGoingSpell(Effect<T> effect) {
        this.effect = effect;
    }

    public Spell on(T target) {
        this.target = target;
        return () -> effect.affect(target);
    }

}
