package com.tamazombie.portableGame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tamazombie.abstractModel.IPlayer;
import com.tamazombie.abstractView.IGameView;
import com.tamazombie.concreteIoC.IoC;
import com.tamazombie.concreteIoC.IoCType;
import javafx.scene.paint.Color;

/**
 * Created with IntelliJ IDEA.
 * User: David Bottiau
 * Date: 11/03/14
 * Time: 19:52
 * To change this template use File | Settings | File Templates.
 */
public final class MyLibgdxGame extends Game {
    // Example of how to get a new object (or current object if existing like a singleton)
    // TODO : use navigation service
    private IGameView _view = IoC.GetInstance(IGameView.class, IoCType.Singleton);
    private SpriteBatch _spriteBatch;

    @Override
    public void create() {
        // TODO : make instances of textures, sound, spriteBatch and other objects
        _spriteBatch = new SpriteBatch();
    }

    @Override
    public void render() {
        // clear the screen with a CORNFLOWERBLUE color.
        Gdx.gl.glClearColor((float)Color.CORNFLOWERBLUE.getRed(), (float)Color.CORNFLOWERBLUE.getGreen(), (float)Color.CORNFLOWERBLUE.getBlue(), 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // TODO : Update with a view object
        _view.Update();

        // TODO : Draw with a view object
        _spriteBatch.begin();

        _view.Draw(_spriteBatch);

        _spriteBatch.end();
    }

    @Override
    public void dispose() {
        // TODO : dispose of all the native resources (spriteBatch, textures, sound, ...)
    }
}