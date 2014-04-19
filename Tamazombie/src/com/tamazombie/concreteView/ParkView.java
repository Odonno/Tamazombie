package com.tamazombie.concreteView;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tamazombie.abstractLogic.IParkViewModel;
import com.tamazombie.abstractView.IBackground;
import com.tamazombie.abstractView.IButton;
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
    private IBackground _background;
    private IButton _buttonFeed;
    private IButton _buttonAmuse;
    private IButton _buttonTown;

    public ParkView(IParkViewModel parkViewModel, IBackground background, IButton buttonFeed, IButton buttonAmuse, IButton buttonTown){
        _parkViewModel = parkViewModel;
        _background = background;
        _buttonFeed = buttonFeed;
        _buttonAmuse = buttonAmuse;
        _buttonTown = buttonTown;
    }

    @Override
    public IParkViewModel GetParkViewModel() {
        return _parkViewModel;
    }

    @Override
    public void Create() {
        // set texture to player
        _parkViewModel.GetPlayer().setTexture(new Texture(Gdx.files.internal("players/zombie.png")));
        _parkViewModel.GetPlayer().setScale(0.15f);

        // set texture to background
        _background.setTexture(new Texture(Gdx.files.internal("backgrounds/background.png")));

        // set textures to buttons
        _buttonFeed.setTexture(new Texture(Gdx.files.internal("buttons/buttonFeed.png")));
        _buttonFeed.setPosition(-150, 120);

        _buttonAmuse.setTexture(new Texture(Gdx.files.internal("buttons/buttonAmuse.png")));
        _buttonAmuse.setPosition(40, 120);

        _buttonTown.setTexture(new Texture(Gdx.files.internal("buttons/buttonTown.png")));
        _buttonTown.setPosition(230, 120);
    }

    @Override
    public void Update() {
        // TODO : UPDATE logic
        _parkViewModel.PlayerMove(Gdx.graphics.getDeltaTime());

        int x = Gdx.input.getX();
        int y = Gdx.input.getY();

        // TODO : Update buttons
        _buttonFeed.IsHover(x, y);
        _buttonAmuse.IsHover(x, y);
        _buttonTown.IsHover(x, y);

        // TODO : Check the user click a button
    }

    @Override
    public void Draw(SpriteBatch spriteBatch) {
        // TODO : Draw textures (images), play sound, ...
        _background.draw(spriteBatch);

        _buttonFeed.draw(spriteBatch);
        _buttonAmuse.draw(spriteBatch);
        _buttonTown.draw(spriteBatch);

        _parkViewModel.GetPlayer().draw(spriteBatch);
    }
}
