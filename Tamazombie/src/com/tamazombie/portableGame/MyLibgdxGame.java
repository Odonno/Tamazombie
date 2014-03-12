package com.tamazombie.portableGame;

import com.badlogic.gdx.Game;

/**
 * Created with IntelliJ IDEA.
 * User: David Bottiau
 * Date: 11/03/14
 * Time: 19:52
 * To change this template use File | Settings | File Templates.
 */

public class MyLibgdxGame extends Game {
    private IoCBootstrapper _iocBootstrapper = new IoCBootstrapper();

    @Override
    public void create() {
        // TODO : use PicoContainer in modules (Logic, Services or here in Main)
    }
}
