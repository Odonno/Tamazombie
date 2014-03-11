package com.example.Android;

import android.app.Activity;
import android.os.Bundle;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.example.portableGame.MyLibgdxGame;

public class GameAndroidStarter extends AndroidApplication {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
        cfg.useAccelerometer = false;
        cfg.useCompass = false;
        cfg.useWakelock = true;
        cfg.useGL20 = true;
        initialize(new MyLibgdxGame(), cfg);
    }
}
