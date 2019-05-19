package com.game.madgic;

/**
 * @author benjaminmartinez
 * Date: 2019-05-18
 */
public  class CreatureSpell extends TargetingSpell<Creature> {

    private final Creature target;
    private final Effect<Creature> effect;

    public CreatureSpell(Creature creature, Effect<Creature> effect){
        this.effect = effect;
        this.target = creature;
    }

    @Override
    public Effect getEffect() {
        return effect;
    }

    @Override
    public Creature getTarget() {
        return target;
    }
}
