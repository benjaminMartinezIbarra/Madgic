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

        this.creature = mock(Creature.class);
        this.enchant = mock(Enchantment.class);
        this.sorcerer = new Sorcerer();
    }

    @Test
    public void resolveKillCreatureSpell() {

        this.sorcerer.casts(new Spell(() -> this.creature.die()));

        this.sorcerer.casts(new Spell(() -> {
            this.enchant.die();
            SpellCastSpec.log.info("BOOM");
        }));

        then(this.enchant).should().die();
        verify(this.creature, times(1)).die();
    }

    @Test
    public void ResolveCounterSpellBeforeAvadakedavra() {

        final Spell avadakedavra = new Spell(() -> this.creature.die());

        final Spell expeliarmus = new Spell(() -> avadakedavra.destroy());

        expeliarmus.resolve();
        avadakedavra.resolve();

        then(this.creature).shouldHaveZeroInteractions();

    }

    @Test
    public void resolveAvadaKedabraBeforeCounterSpell() {

        final Spell avadakedavra = new Spell(() -> this.creature.die());

        final Spell expeliarmus = new Spell(() -> avadakedavra.destroy());

        avadakedavra.resolve();
        expeliarmus.resolve();

        then(this.creature).should().die();

    }

}
