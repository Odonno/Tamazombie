package com.tamazombie.concreteModel;

import com.tamazombie.abstractModel.Enemy;
import com.tamazombie.abstractModel.IZombieEnemy;


/**
 * Created by Pierrick on 19/03/14.
 */
public final class ZombieEnemy extends Enemy implements IZombieEnemy {
    @Override
    public String GetName() {
        return _name;
    }
    @Override
    public float GetHealth() {
        return _health;
    }

    @Override
    public float GetDamages() {
        return _damages;
    }

    @Override
    public float GetDefense() {
        return _defense;
    }

    @Override
    public void SetHealth(float health) {
        _health = health;
    }

    @Override
    public Boolean IsDead() {
        return _health >= 500f;
    }
}
