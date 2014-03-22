package com.tamazombie.abstractView;

import com.tamazombie.abstractModel.ISprite;

/**
 * Created by martinvittu on 21/03/2014.
 */
public interface IButton extends ISprite {
    public boolean IsClickable(int x, int y);
    public boolean IsHover(int x, int y);

    public boolean Click(int x, int y);
}
