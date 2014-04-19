package com.tamazombie.abstractView;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created with IntelliJ IDEA.
 * User: David Bottiau
 * Date: 12/03/14
 * Time: 13:48
 * To change this template use File | Settings | File Templates.
 */
public interface IGameView {
    public void Create();
    public void Update();
    public void Draw(SpriteBatch spriteBatch);
    public void Dispose();
}
