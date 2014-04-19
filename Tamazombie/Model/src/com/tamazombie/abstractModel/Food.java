package com.tamazombie.abstractModel;

import com.tamazombie.abstractModel.IFood;
import com.tamazombie.abstractModel.SpriteBase;

/**
 * Created by Pierrick on 21/03/14.
 */
public abstract class Food extends SpriteBase implements IFood {
    protected String _name;
    protected float _health_delivered;
}
