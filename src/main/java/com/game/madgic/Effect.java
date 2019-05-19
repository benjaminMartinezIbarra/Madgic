package com.game.madgic;

/**
 * @author benjaminmartinez
 * Date: 2019-05-19
 */
@FunctionalInterface
public interface Effect<T> {

    void affect(T target);

}
