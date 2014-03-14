package com.tamazombie.abstractModel;

import com.tamazombie.commonModel.Gender;

/**
 * Created with IntelliJ IDEA.
 * User: David Bottiau
 * Date: 11/03/14
 * Time: 23:00
 * To change this template use File | Settings | File Templates.
 */
public interface IPlayer {
    public String GetName();
    public Gender GetGender();
    public float GetHealth();
    public float GetHunger();
    public float GetMentality();
    public float GetDamages();
    public float GetDefense();
}
