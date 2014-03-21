package com.tamazombie.abstractModel;

/**
 * Created by Pierrick on 21/03/14.
 */
public interface ITown extends ISprite
{
    public String GetName();
    public float GetDefenseLevel();
    public int GetPopulationTotal();
    public int GetLuckFood();
    public char GetWarning();
}
