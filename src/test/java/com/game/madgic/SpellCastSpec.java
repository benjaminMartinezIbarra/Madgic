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
    private Sorcerer sorcerer;

    @Before
    public void setup() {
        creature = mock(Creature.class);
        sorcerer = new Sorcerer();
    }

    @Test
    public void resolveKillCreatureSpell() {
        sorcerer.casts(new Spell(() -> creature.die()));
        verify(creature, times(1)).die();
    }

    @Test
    public void ResolveCounterSpellBeforeAvadakedavra() {

        Spell avadakedavra = new Spell(() -> creature.die());

        Spell expeliarmus = new Spell(() -> avadakedavra.destroy());

        expeliarmus.resolve();
        avadakedavra.resolve();

        then(creature).shouldHaveZeroInteractions();

    }

    @Test
    public void resolveAvadaKedabraBeforeCounterSpell() {

        Spell avadakedavra = new Spell(() -> creature.die());

        Spell expeliarmus = new Spell(() -> avadakedavra.destroy());

        avadakedavra.resolve();
        expeliarmus.resolve();

        then(creature).should().die();

    }

    @Test
    public void weaveASpellThenChoseTarget() {
        this.sorcerer.cast((Creature creature) -> creature.die(), this.creature);
        then(creature).should().die();

    }

    @Test
    public void weaveASpellThenChoseTarget2() {
        this.sorcerer.cast((Creature creature) -> creature.die()).on(this.creature);
        then(creature).should().die();

    }

}
