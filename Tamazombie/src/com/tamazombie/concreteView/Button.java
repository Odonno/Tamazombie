package com.tamazombie.concreteView;

import com.tamazombie.abstractModel.SpriteBase;
import com.tamazombie.abstractView.IButton;

/**
 * Created by martinvittu on 21/03/2014.
 */
public final class Button extends SpriteBase implements IButton {
    // TODO : use a 'frequency' variable to space out clicks
    private float _clickFrequency = 0.1f;

    @Override
    public boolean IsClicked(int x, int y) {
        // TODO : check if the pixel (x, y) is inside the button => use IsHover
        // TODO : check if the click is now 'clickable' (in regard of the click frequency)
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean IsHover(int x, int y) {
        // TODO : check if the pixel (x, y) is inside the button
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
