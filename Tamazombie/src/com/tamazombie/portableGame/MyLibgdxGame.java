package com.tamazombie.portableGame;

import com.badlogic.gdx.Game;
import com.tamazombie.abstractModel.IPlayer;
import com.tamazombie.portableIoC.IoC;
import com.tamazombie.portableIoC.IoCType;

/**
 * Created with IntelliJ IDEA.
 * User: David Bottiau
 * Date: 11/03/14
 * Time: 19:52
 * To change this template use File | Settings | File Templates.
 */
public class MyLibgdxGame extends Game {
    // Example of how to get a new object (or current object if existing like a singleton)
    private IPlayer _player = IoC.GetPico(IoCType.Singleton).getComponent(IPlayer.class);

    @Override
    public void create() {
        // TODO : use PicoContainer in modules (Logic, Services or here in Main)
    }
}