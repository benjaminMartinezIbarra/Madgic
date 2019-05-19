package com.game.madgic;

/**
 * @author benjaminmartinez
 * Date: 2019-05-17
 */
@FunctionalInterface
public interface Spell extends HasEffect {

    void resolve();

    @Override
    default Effect getEffect(){
        return null;
    }

}
