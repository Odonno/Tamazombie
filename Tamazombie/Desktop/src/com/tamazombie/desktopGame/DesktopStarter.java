package com.tamazombie.desktopGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.tamazombie.portableGame.MyLibgdxGame;

/**
 * Created with IntelliJ IDEA.
 * User: David Bottiau
 * Date: 11/03/14
 * Time: 19:46
 * To change this template use File | Settings | File Templates.
 */
public class DesktopStarter {
    public static void main(String[] args) {
        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        cfg.title = "TamaZombie";
        cfg.useGL20 = true;
        cfg.width = 1152;
        cfg.height = 648;



        new LwjglApplication(new MyLibgdxGame(), cfg);

        Sound mSound;
        mSound = Gdx.audio.newSound(Gdx.files.internal("C:/Users/Pierrick/Documents/GitHub/Tamazombie/Tamazombie/Android/assets/musics/campagne.mp3"));

        //_buttonMusicTexture = new Texture(Gdx.files.internal("buttons/buttonMusic.png"));
        mSound.play();
        mSound.loop();


    }
}
