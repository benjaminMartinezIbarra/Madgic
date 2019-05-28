package com.game.madgic;

/**
 * @author benjaminmartinez
 * Date: 2019-05-17
 */

public class Creature {

    private final String name;
    private final int startHp;
    private int currentHp;
    private boolean dead;

    public Creature(String name, final int startHp) {
        this.name = name;
        this.startHp = startHp;
        currentHp = this.startHp;
    }

    public void die() {
        dead = true;
    }

    public void inflictDamage(int dammage) {
        this.setHealthPoints(this.getHealthPoints() - dammage);
        if (this.getHealthPoints() <= 0) {
            this.die();
        }
    }

    public boolean isDead() {
        return dead;
    }

    public int getHealthPoints() {
        return this.currentHp;
    }

    private void setHealthPoints(int healPoints) {
        if (healPoints >= this.startHp) {
            this.currentHp = this.startHp;
        } else {
            this.currentHp = healPoints;
        }
    }

    public void giveHealth(int healPoints) {
        this.setHealthPoints(this.getHealthPoints() + healPoints);

    }

    public String getName() {
        return name;
    }
}
