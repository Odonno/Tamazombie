package com.tamazombie.concreteView;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tamazombie.abstractLogic.IParkViewModel;
import com.tamazombie.abstractView.IBackground;
import com.tamazombie.abstractView.IButton;
import com.tamazombie.abstractView.IParkView;
import com.tamazombie.abstractView.ITownView;
import com.tamazombie.portableServices.INavigationService;


/**
 * Created with IntelliJ IDEA.
 * User: David Bottiau
 * Date: 12/03/14
 * Time: 13:48
 * To change this template use File | Settings | File Templates.
 */

public final class ParkView implements IParkView {
    private IParkViewModel _parkViewModel;

    private INavigationService _navigationService;

    private IBackground _background;
    private IButton _buttonFeed;
    private IButton _buttonAmuse;
    private IButton _buttonTown;

    private Texture _zombieTexture;
    private Texture _backgroundTexture;
    private Texture _buttonFeedTexture;
    private Texture _buttonAmuseTexture;
    private Texture _buttonTownTexture;

    public ParkView(IParkViewModel parkViewModel, IBackground background, IButton buttonFeed, IButton buttonAmuse, IButton buttonTown, INavigationService navigationService) {
        _parkViewModel = parkViewModel;
        _navigationService = navigationService;
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
        // Create textures
        _zombieTexture = new Texture(Gdx.files.internal("players/zombie.png"));
        _backgroundTexture = new Texture(Gdx.files.internal("backgrounds/background.png"));
        _buttonFeedTexture = new Texture(Gdx.files.internal("buttons/buttonFeed.png"));
        _buttonAmuseTexture = new Texture(Gdx.files.internal("buttons/buttonAmuse.png"));
        _buttonTownTexture = new Texture(Gdx.files.internal("buttons/buttonTown.png"));

        // Set textures

        // set texture to player
        _parkViewModel.GetPlayer().setTexture(_zombieTexture);
        _parkViewModel.GetPlayer().setScale(0.15f);


        // set texture to background
        _background.setTexture(_backgroundTexture);

        // set textures to buttons
        _buttonFeed.setTexture(_buttonFeedTexture);
        _buttonFeed.setScale(0.40f);
        _buttonFeed.setPosition(-80, 490);

        _buttonAmuse.setTexture(_buttonAmuseTexture);
        _buttonAmuse.setScale(0.40f);
        _buttonAmuse.setPosition(80, 490);

        _buttonTown.setTexture(_buttonTownTexture);
        _buttonTown.setScale(0.40f);
        _buttonTown.setPosition(240, 490);
    }

    @Override
    public void Update() {
        // UPDATE logic
        float deltatime = Gdx.graphics.getDeltaTime();

        _parkViewModel.PlayerMove(Gdx.graphics.getDeltaTime());

        int x = Gdx.input.getX();
        int y = Gdx.input.getY();

        // Redefine y to calculate correct position
        y = Math.abs(Gdx.graphics.getHeight() - y);

        // Update buttons
        _buttonFeed.Update(deltatime);
        _buttonAmuse.Update(deltatime);
        _buttonTown.Update(deltatime);

        // Check the user click a button
        if (_buttonFeed.IsHover(x, y)) {
            if (Gdx.input.isButtonPressed(Input.Buttons.LEFT) && _buttonFeed.Click(x, y)) {
                // TODO : Update ViewModel
            }
        }
        if (_buttonAmuse.IsHover(x, y)) {
            if (Gdx.input.isButtonPressed(Input.Buttons.LEFT) && _buttonAmuse.Click(x, y)) {
                // TODO : Update ViewModel
            }
        }
        if (_buttonTown.IsHover(x, y)) {
            if (Gdx.input.isButtonPressed(Input.Buttons.LEFT) && _buttonTown.Click(x, y)) {
                _navigationService.Navigate(ITownView.class);
            }
        }
    }

    @Override
    public void Draw(SpriteBatch spriteBatch) {
        // DRAW textures (images), play sound, ...
        _background.draw(spriteBatch);

        _buttonFeed.draw(spriteBatch);
        _buttonAmuse.draw(spriteBatch);
        _buttonTown.draw(spriteBatch);

        _parkViewModel.GetPlayer().draw(spriteBatch);
    }

    @Override
    public void Dispose() {
        // Dispose textures, sounds, ...
        _zombieTexture.dispose();
        _backgroundTexture.dispose();
        _buttonFeedTexture.dispose();
        _buttonAmuseTexture.dispose();
        _buttonTownTexture.dispose();
    }
}
