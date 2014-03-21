package com.tamazombie.concreteModel;

import com.tamazombie.abstractModel.IHumanPlayer;
import com.tamazombie.abstractModel.Player;
import com.tamazombie.commonModel.GameMode;
import com.tamazombie.commonModel.Gender;


/**
 * Created by Pierrick on 19/03/14.
 */
public final class HumanPlayer extends Player implements IHumanPlayer
{
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
        return GameMode.HumanMode;
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
    public Boolean IsDead() {
        return _health >=1000f;
    }
}
