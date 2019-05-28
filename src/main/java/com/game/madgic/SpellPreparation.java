package com.game.madgic;

/**
 * @author benjaminmartinez
 * Date: 2019-05-28
 */
public class SpellPreparation<T> {

    CastOnTarget<T> stuff;

    public SpellPreparation(CastOnTarget<T> stuff) {
        this.stuff = stuff;
    }

    public void on(T target) {
        new Spell(() -> stuff.doCast(target)).resolve();
    }
}
