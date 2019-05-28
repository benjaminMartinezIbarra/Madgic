package com.game.madgic;

/**
 * @author benjaminmartinez
 * Date: 2019-05-17
 */

public class Sorcerer {

    void casts(Spell spell) {
        spell.resolve();

    }

    public void cast(CastOnTarget<Creature> stuff, Creature creature) {
        new Spell(() -> stuff.doCast(creature)).resolve();

    }

    public SpellPreparation cast(CastOnTarget<Creature> stuff) {
        return new SpellPreparation(stuff);

    }
}
