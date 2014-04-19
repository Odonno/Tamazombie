package com.tamazombie.abstractModel;

import com.tamazombie.commonModel.Direction;
import com.tamazombie.commonModel.GameMode;
import com.tamazombie.commonModel.Gender;

/**
 * Created with IntelliJ IDEA.
 * User: David Bottiau
 * Date: 11/03/14
 * Time: 23:00
 * To change this template use File | Settings | File Templates.
 */
public interface IPlayer extends ISprite {
    public String GetName();
    public Gender GetGender();
    public GameMode GetGameMode();
    public float GetHealth();
    public float GetHunger();
    public float GetHungerLimit();
    public float GetMentality();
    public float GetDamages();
    public float GetDefense();
    public Direction GetDirection();

    public void SetHealth(float health);
    public void SetHunger(float hunger);
    public void SetMentality(float mentality);
    public void SetDirection(Direction direction);

    public Boolean IsDead();
}
