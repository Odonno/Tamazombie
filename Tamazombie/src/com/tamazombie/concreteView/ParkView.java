package com.tamazombie.concreteView;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tamazombie.abstractLogic.IParkViewModel;
import com.tamazombie.abstractView.IBackground;
import com.tamazombie.abstractView.IParkView;


/**
 * Created with IntelliJ IDEA.
 * User: David Bottiau
 * Date: 12/03/14
 * Time: 13:48
 * To change this template use File | Settings | File Templates.
 */

public final class ParkView implements IParkView {
    private IParkViewModel _parkViewModel;
    // TODO : create buttons
    private IBackground _background;

    public ParkView(IParkViewModel parkViewModel, IBackground background){
        _parkViewModel = parkViewModel;
        // TODO : initialize buttons with Injection (IoC)
        _background = background;
    }

    @Override
    public IParkViewModel GetParkViewModel() {
        return _parkViewModel;
    }

    @Override
    public void Create() {
        _parkViewModel.GetPlayer().setTexture(new Texture(Gdx.files.internal("zombie.png")));
        _parkViewModel.GetPlayer().setScale(0.15f);

        // TODO : set textures to buttons
        _background.setTexture(new Texture(Gdx.files.internal("background.png")));


        //xButton.setTexture(new Texture(Gdx.files.internal("Button.png")));
    }

    @Override
    public void Update() {
        // TODO : UPDATE logic

        // TODO : Get Click position and check the user click the button
    }

    @Override
    public void Draw(SpriteBatch spriteBatch) {
        // TODO : Draw textures (images), play sound, ...
        _background.draw(spriteBatch);

        _parkViewModel.GetPlayer().draw(spriteBatch);

        // TODO : draw texture (buttons)
    }
}
