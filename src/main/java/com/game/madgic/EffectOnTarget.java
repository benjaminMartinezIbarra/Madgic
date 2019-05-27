package com.game.madgic;

/**
 * @author benjaminmartinez
 * Date: 2019-05-27
 */

public abstract class EffectOnTarget<T> implements Effect, WithTarget<T> {

    T target;

    public EffectOnTarget(final T target) {
        this.target = target;
    }

    public abstract void resolve(T target);

    @Override
    public void resolve() {
        this.resolve(this.getTarget());
    }

    @Override
    public T getTarget() {
        return this.target;
    }
}