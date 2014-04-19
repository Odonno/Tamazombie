package com.tamazombie.abstractModel;



/**
 * Created by Pierrick on 21/03/14.
 */
public abstract class Enemy extends SpriteBase implements IEnemy {
    protected String _name;
    protected float _health;
    protected float _damages;
    protected float _defense;
}
