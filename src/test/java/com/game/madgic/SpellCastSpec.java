package com.game.madgic;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * @author benjaminmartinez
 * Date: 2019-05-18
 */
@Slf4j
public class SpellCastSpec {

    private Creature creature;
    private Enchantment enchant;
    private Sorcerer sorcerer;

    @Before
    public void setup() {

        creature = mock(Creature.class);
        enchant = mock(Enchantment.class);
        sorcerer = new Sorcerer();
    }

    @Test
    public void whenTerrorSpellIsCastedOnCreatureThenCreatureDies() {

        sorcerer.casts(creature, Creature::die);
        sorcerer.casts(creature, (toto -> toto.die()));
        sorcerer.casts(() -> {
            enchant.die();
            log.info("BOOM");
        });
        sorcerer.casts(() -> log.info("SHAZAM"));
        sorcerer.casts(new TargetingSpell<Creature>() {
            @Override
            public Effect<Creature> getEffect() {
                return target -> target.die();
            }

            @Override
            public Creature getTarget() {
                return creature;
            }
        });

        then(enchant).should().die();
        verify(creature, times(3)).die();
    }

    @Test
    public void castOngoingSpellAndAssureSpellIsCastedWhenWeavingIsComplete() {

        Spell spell = new OnGoingSpell<>(Creature::die).on(creature);
        sorcerer.casts(spell);
        then(creature).should().die();

    }

}
