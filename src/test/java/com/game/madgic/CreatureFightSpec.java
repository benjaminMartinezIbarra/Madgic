package com.game.madgic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

/**
 * @author benjaminmartinez
 * Date: 2019-05-28
 */
public class CreatureFightSpec {

    private Creature dragon;

    @Before
    public void setup() {
        this.dragon = new Creature("Dragon", 3);
    }

    @Test
    public void creatureReceiveDamage() {
        final Creature creature = mock(Creature.class);
        final CastOnTarget<Creature> cast = (Creature mob) -> mob.inflictDamage(2);
        cast.doCast(creature);
        then(creature).should().inflictDamage(2);
    }

    @Test
    public void creatureReceiveDamageMoreThanHerHealthThenIsDead() {
        final CastOnTarget<Creature> cast = (Creature mob) -> mob.inflictDamage(4);
        cast.doCast(this.dragon);
        assertThat("mob must have very low hp", this.dragon.getHealthPoints() == -1);
        assertThat("mob should be dead", this.dragon.isDead());
    }

    @Test
    public void creatureReceiveHealing() {
        final CastOnTarget<Creature> cast = (Creature mob) -> mob.giveHealth(2);
        cast.doCast(this.dragon);
        assertThat("mob must still have same health", this.dragon.getHealthPoints() == 3);

    }

    @Test
    public void creatureReceiveDamageThenHealing() {
        ((CastOnTarget<Creature>) (Creature mob) -> mob.inflictDamage(2)).doCast(this.dragon);
        ((CastOnTarget<Creature>) (Creature mob) -> mob.giveHealth(1)).doCast(this.dragon);
        Assert.assertEquals(2, this.dragon.getHealthPoints());

    }
}
