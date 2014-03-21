package com.tamazombie.abstractModel;


/**
 * Created by Pierrick on 19/03/14.
 */
public interface IEnemy extends ISprite
{

    public String GetName();
    public float GetHealth();
    public float GetDamages();
    public float GetDefense();

    public Boolean IsDead();

}
