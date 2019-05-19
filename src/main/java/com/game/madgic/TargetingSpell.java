package com.game.madgic;

/**
 * @author benjaminmartinez
 * Date: 2019-05-18
 */

public abstract class TargetingSpell<T> implements Spell, WithTarget<T> {


    @Override
    public void resolve() {
        getEffect().affect(getTarget());
    }

}
