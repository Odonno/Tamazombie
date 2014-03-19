package com.tamazombie.abstractModel;

import com.tamazombie.commonModel.GameMode;
import com.tamazombie.commonModel.Gender;

/**
 * Created by Pierrick on 19/03/14.
 */
public interface IEnemy extends ISprite
{

    public String GetName();
    public Gender GetGender();
    public GameMode GetGameMode();
    public float GetHealth();
    public float GetHunger();
    public float GetMentality();
    public float GetDamages();
    public float GetDefense();

    public Boolean IsDead();

}
