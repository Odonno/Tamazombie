package com.tamazombie.abstractView;

import com.tamazombie.abstractModel.ISprite;

/**
 * Created by martinvittu on 21/03/2014.
 */
public interface IButton extends ISprite {
    public boolean IsHover(int x, int y);
    public void Update(float deltaTime);
    public boolean Click(int x, int y);
}
