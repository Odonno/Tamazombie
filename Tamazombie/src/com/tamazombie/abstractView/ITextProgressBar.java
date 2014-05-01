package com.tamazombie.abstractView;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created with IntelliJ IDEA.
 * User: David Bottiau
 * Date: 01/05/14
 * Time: 17:50
 * To change this template use File | Settings | File Templates.
 */
public interface ITextProgressBar {
    public void setText(String text);
    public void setMin(int min);
    public void setMax(int max);
    public void setValue(int value);

    public void Draw(SpriteBatch spriteBatch);
}
