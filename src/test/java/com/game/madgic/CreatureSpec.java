package com.game.madgic;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author benjaminmartinez
 * Date: 2019-05-28
 */
public class CreatureSpec {

    @Test
    public void createCreature() {
        final int hp = 3;
        final String name = "kobold";
        final Creature creature = new Creature(name, hp);
        Assert.assertEquals(hp, creature.getHealthPoints());
        Assert.assertEquals(name, creature.getName());
    }
}
