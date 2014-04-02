package com.tamazombie.concreteView;

import com.tamazombie.abstractModel.SpriteBase;
import com.tamazombie.abstractView.IButton;

/**
 * Created by martinvittu on 21/03/2014.
 */
public final class Button extends SpriteBase implements IButton {
    private final float _clickFrequency = 0.1f;
    private float _lastTimeClick = 0f;

    /**
     * Inform if the button can be clicked
     * @param x X position of the mouse
     * @param y Y position of the mouse
     * @return
     */
    private boolean IsClickable(int x, int y) {
        // TODO : check if the pixel (x, y) is inside the button => use IsHover
        // TODO : check if the click is now 'clickable' (in regard of the click frequency)
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Inform if the button is hovered by the mouse
     * @param x X position of the mouse
     * @param y Y position of the mouse
     * @return
     */
    @Override
    public boolean IsHover(int x, int y) {
        if (intersect(x, y)) {
            setColor(1f, 1f, 1f, 0.8f);
            return true;
        }
        else {
            setColor(1f, 1f, 1f, 1f);
            return false;
        }
    }

    /**
     * Update buttons paramaters
     * @param deltaTime
     */
    @Override
    public void Update(float deltaTime) {
        _lastTimeClick -= deltaTime;
    }

    /**
     * Execute click method on this button
     * @param x X position of the mouse
     * @param y Y position of the mouse
     */
    @Override
    public boolean Click(int x, int y) {
        // use the 'frequency' variable to space out clicks
        if (IsClickable(x, y)){
            _lastTimeClick = _clickFrequency;
            return true;
        }

        return false;
    }
}
