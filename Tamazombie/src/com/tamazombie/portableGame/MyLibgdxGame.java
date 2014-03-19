package com.tamazombie.portableGame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.tamazombie.abstractModel.IPlayer;
import com.tamazombie.concreteIoC.IoC;
import com.tamazombie.concreteIoC.IoCType;

/**
 * Created with IntelliJ IDEA.
 * User: David Bottiau
 * Date: 11/03/14
 * Time: 19:52
 * To change this template use File | Settings | File Templates.
 */
public final class MyLibgdxGame extends Game {
    // Example of how to get a new object (or current object if existing like a singleton)
    // TODO : remove this field and use Logic instead
    private IPlayer _player = IoC.GetInstance(IPlayer.class, IoCType.Singleton);

    @Override
    public void create() {
        // TODO : make instances of textures, sound, spriteBatch and other objects
    }

    @Override
    public void render() {
        // clear the screen with a CORNFLOWERBLUE color.
        Gdx.gl.glClearColor((float)100, (float)149, (float)237, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // TODO : UPDATE logic

        // TODO : DRAW textures (images), play sound, ...
    }

    @Override
    public void dispose() {
        // TODO : dispose of all the native resources (spriteBatch, textures, sound, ...)
    }
}