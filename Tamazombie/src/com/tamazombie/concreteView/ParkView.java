package com.tamazombie.concreteView;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tamazombie.abstractLogic.IParkViewModel;
import com.tamazombie.abstractView.IParkView;

/**
 * Created with IntelliJ IDEA.
 * User: David Bottiau
 * Date: 12/03/14
 * Time: 13:48
 * To change this template use File | Settings | File Templates.
 */
public class ParkView implements IParkView {
    private IParkViewModel _parkViewModel;

    public ParkView(IParkViewModel parkViewModel){
        _parkViewModel = parkViewModel;
    }

    @Override
    public IParkViewModel GetParkViewModel() {
        return _parkViewModel;
    }

    @Override
    public void Create() {
        _parkViewModel.getPlayer().setTexture(new Texture(Gdx.files.internal("Walkers.png")));
    }

    @Override
    public void Update() {
        // TODO : UPDATE logic
    }

    @Override
    public void Draw(SpriteBatch spriteBatch) {
        // TODO : DRAW textures (images), play sound, ...
        _parkViewModel.getPlayer().draw(spriteBatch);
    }
}
