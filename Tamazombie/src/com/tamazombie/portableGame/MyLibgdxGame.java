package com.tamazombie.portableGame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tamazombie.abstractView.IParkView;
import com.tamazombie.concreteIoC.IoC;
import com.tamazombie.portableServices.INavigationService;

/**
 * Created with IntelliJ IDEA.
 * User: David Bottiau
 * Date: 11/03/14
 * Time: 19:52
 * To change this template use File | Settings | File Templates.
 */
public final class MyLibgdxGame extends Game {
    // Example of how to get a new object (or current object if existing like a singleton)
    // using navigation service
    private INavigationService _navigationService = IoC.GetInstance(INavigationService.class);
    private SpriteBatch _spriteBatch;

    @Override
    public void create() {
        // make instances of textures, sound, spriteBatch and other objects
        _spriteBatch = new SpriteBatch();

        // Setup navigation
        _navigationService.Navigate(IParkView.class);
    }

    @Override
    public void render() {
        // clear the screen with a CORNFLOWERBLUE color.
        Gdx.gl.glClearColor((float)100/255, (float)149/255, (float)237/255, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Update with a view object
        _navigationService.GetView().Update();

        // Draw with a view object
        _spriteBatch.begin();

        _navigationService.GetView().Draw(_spriteBatch);

        _spriteBatch.end();
    }

    @Override
    public void dispose() {
        // dispose of all the native resources (spriteBatch, textures, sound, ...)
        _spriteBatch.dispose();

        // dispose navigation and all views inside
        _navigationService.Dispose();
    }
}