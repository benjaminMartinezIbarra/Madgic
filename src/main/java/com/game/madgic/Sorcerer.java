package com.game.madgic;

/**
 * @author benjaminmartinez
 * Date: 2019-05-17
 */

public class Sorcerer {

    void casts(Spell spell) {
        spell.resolve();

    }

    void casts(final Creature creature, Effect<Creature> effect) {
        new CreatureSpell(creature, effect).resolve();
    }

}
