package com.tamazombie.abstractModel;

import com.tamazombie.commonModel.Direction;
import com.tamazombie.commonModel.Gender;

/**
 * Created with IntelliJ IDEA.
 * User: David Bottiau
 * Date: 11/03/14
 * Time: 23:00
 * To change this template use File | Settings | File Templates.
 */
public abstract class Player extends SpriteBase implements IPlayer,IFood {
    protected String _name;
    protected Gender _gender;
    protected float _health;
    protected float _hunger;
    protected float _mentality;
    protected float _damages;
    protected float _defense;
    protected Direction _direction;
}
