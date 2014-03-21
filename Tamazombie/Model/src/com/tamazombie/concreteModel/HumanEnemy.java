package com.tamazombie.concreteModel;

import com.tamazombie.abstractModel.Enemy;
import com.tamazombie.abstractModel.IHumanEnemy;


/**
 * Created by Pierrick on 19/03/14.
 */
public final class HumanEnemy extends Enemy implements IHumanEnemy {
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
    public Boolean IsDead() {
        return _health >= 150f;
    }
}
