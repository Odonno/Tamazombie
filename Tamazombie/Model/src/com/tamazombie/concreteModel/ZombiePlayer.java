package com.tamazombie.concreteModel;

import com.tamazombie.abstractModel.IZombiePlayer;
import com.tamazombie.abstractModel.Player;
import com.tamazombie.commonModel.GameMode;
import com.tamazombie.commonModel.Gender;

/**
 * Created with IntelliJ IDEA.
 * User: David Bottiau
 * Date: 14/03/14
 * Time: 14:17
 * To change this template use File | Settings | File Templates.
 */
public final class ZombiePlayer extends Player implements IZombiePlayer {
    @Override
    public String GetName() {
        return _name;
    }

    @Override
    public Gender GetGender() {
        return _gender;
    }

    @Override
    public GameMode GetGameMode() {
        return GameMode.ZombieMode;
    }

    @Override
    public float GetHealth() {
        return _health;
    }

    @Override
    public float GetHunger() {
        return _hunger;
    }

    @Override
    public float GetHungerLimit() {
        return 1000f;
    }

    @Override
    public float GetMentality() {
        return _mentality;
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
    public void SetHunger(float hunger) {
        _hunger = hunger;
    }

    @Override
    public Boolean IsDead() {
        return _health >= 200f;
    }
}
