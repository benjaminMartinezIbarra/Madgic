package com.game.madgic;

/**
 * @author benjaminmartinez
 * Date: 2019-05-28
 */
@FunctionalInterface
public interface CastOnTarget<T> {

    void doCast(T target);


}
