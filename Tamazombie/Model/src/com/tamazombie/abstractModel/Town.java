package com.tamazombie.abstractModel;

/**
 * Created by Pierrick on 21/03/14.
 */
public abstract class Town extends SpriteBase implements ITown
{

    protected String _name;
    protected float _defense_level;
    protected int _population_total;
    protected int _luck_food;
    protected char _warning;

}
