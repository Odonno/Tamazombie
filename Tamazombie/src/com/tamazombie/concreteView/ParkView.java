package com.tamazombie.concreteView;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tamazombie.abstractLogic.IParkViewModel;
import com.tamazombie.abstractView.*;
import com.tamazombie.portableServices.INavigationService;
import com.tamazombie.abstractModel.IPlayer;
import com.tamazombie.concreteModel.ZombiePlayer;

import javax.swing.*;
import java.util.Random;


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
    private IButton _buttonMusic;

    private ITextProgressBar _healthProgressBar;
    private ITextProgressBar _hungryProgressBar;
    private ITextProgressBar _mentalityProgressBar;

    private Texture _zombieTexture;
    private Texture _backgroundTexture;
    private Texture _buttonFeedTexture;
    private Texture _buttonAmuseTexture;
    private Texture _buttonTownTexture;
    private Texture _buttonMusicTexture;


    public ParkView(IParkViewModel parkViewModel, IBackground background,
                    IButton buttonFeed, IButton buttonAmuse, IButton buttonTown, IButton buttonMusic,
                    ITextProgressBar healthProgressBar, ITextProgressBar hungryProgressBar, ITextProgressBar mentalityProgressBar,
                    INavigationService navigationService) {
        _parkViewModel = parkViewModel;
        _navigationService = navigationService;
        _background = background;
        _buttonFeed = buttonFeed;
        _buttonAmuse = buttonAmuse;
        _buttonTown = buttonTown;
        _buttonMusic = buttonMusic;
        _healthProgressBar = healthProgressBar;
        _hungryProgressBar = hungryProgressBar;
        _mentalityProgressBar = mentalityProgressBar;
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
        _buttonMusicTexture = new Texture(Gdx.files.internal("buttons/buttonMusic.png"));

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

        _buttonMusic.setTexture(_buttonMusicTexture);
        _buttonMusic.setScale(0.40f);
        _buttonMusic.setPosition(1050, 540);

        // set text and position to progress bars
        _healthProgressBar.setText("Vie : ");
        _healthProgressBar.setMin(0);
        _healthProgressBar.setMax(100);
        _healthProgressBar.setValue(0);
        _healthProgressBar.setPosition(40, 70);

        _hungryProgressBar.setText("Faim : ");
        _hungryProgressBar.setMin(-50);
        _hungryProgressBar.setMax(100);
        _hungryProgressBar.setValue(0);
        _hungryProgressBar.setPosition(40, 40);

        _mentalityProgressBar.setText("Mental : ");
        _mentalityProgressBar.setMin(-100);
        _mentalityProgressBar.setMax(100);
        _mentalityProgressBar.setValue(0);
        _mentalityProgressBar.setPosition(40, 10);

        _parkViewModel.GetPlayer().SetHealth(100);
        _parkViewModel.GetPlayer().SetMentality(100);
    }

    @Override
    public void Update() {
        // UPDATE logic
        float deltatime = Gdx.graphics.getDeltaTime();

        _parkViewModel.PlayerMove(deltatime);
        _parkViewModel.PlayerHungry(deltatime);
        _parkViewModel.PlayerMentality(deltatime);

        int x = Gdx.input.getX();
        int y = Gdx.input.getY();

        // Redefine y to calculate correct position
        y = Math.abs(Gdx.graphics.getHeight() - y);

        // Update buttons
        _buttonFeed.Update(deltatime);
        _buttonAmuse.Update(deltatime);
        _buttonTown.Update(deltatime);
        _buttonMusic.Update(deltatime);

        // Check the user click a button
        if (_buttonFeed.IsHover(x, y)) {
            if (Gdx.input.isButtonPressed(Input.Buttons.LEFT) && _buttonFeed.Click(x, y)) {
                // TODO : Update ViewModel
                /*_player.SetHunger(_player.GetHunger()+ 20);
                 if (_player.GetHunger() > 100)
                 {
                      _player.SetHunger(100);
                 }*/
                /*_zombieplayer.SetHunger(_zombieplayer.GetHunger()+ 20);
                if (_zombieplayer.GetHunger() > 100)
                {
                    _zombieplayer.SetHunger(100);
                }
                _zombieplayer.SetHealth(_zombieplayer.GetHealth()+ 15);
                if (_zombieplayer.GetHealth() > 100)
                {
                    _zombieplayer.SetHealth(100);
                }*/
            }
        }
        if (_buttonAmuse.IsHover(x, y)) {
            if (Gdx.input.isButtonPressed(Input.Buttons.LEFT) && _buttonAmuse.Click(x, y)) {
                // TODO : Update ViewModel
                /*_zombieplayer.SetMentality(_zombieplayer.GetMentality() + 20);
                if (_zombieplayer.GetMentality() > 100)
                {
                    _zombieplayer.SetMentality(100);
                }
                _zombieplayer.SetHunger(_zombieplayer.GetHunger()- 8);
                if (_zombieplayer.GetHunger() < 0)
                {
                    _zombieplayer.SetHunger(0);
                }*/
            }
        }
        if (_buttonTown.IsHover(x, y)) {
            if (Gdx.input.isButtonPressed(Input.Buttons.LEFT) && _buttonTown.Click(x, y)) {
                //_navigationService.Navigate(ITownView.class);

                Object[] result = goTown();
                float Health = (Float) result[0];
                float Hunger = (Float) result[1];

                _parkViewModel.GetPlayer().SetHealth(Health); //->set la vie
                _parkViewModel.GetPlayer().SetHunger(Hunger); // ->set la faim

                if (Health <= 0) {
                    JOptionPane jop = new JOptionPane();
                    ImageIcon img = new ImageIcon("other/Dead.png");
                    jop.showMessageDialog(null, "Perdu !", "LOSE", JOptionPane.ERROR_MESSAGE, img);
                } else {
                    JOptionPane jop = new JOptionPane();
                    ImageIcon img = new ImageIcon("other/miam.png");
                    jop.showMessageDialog(null, "Il vous reste " + Health + " PV! \nVous une faim de " + Hunger + "/100!", "Town Party", JOptionPane.ERROR_MESSAGE, img);
                }

            }
        }
        if (_buttonMusic.IsHover(x, y)) {
            if (Gdx.input.isButtonPressed(Input.Buttons.LEFT) && _buttonMusic.Click(x, y)) {
                //recuperer le msound qui est dans  DesktopStarter et faire msound.dispose();
            }
        }

        // Update progress bar values
        _healthProgressBar.setValue((int) (100 * _parkViewModel.GetPlayer().GetHealth() / 100));
        _hungryProgressBar.setValue((int) (100 * _parkViewModel.GetPlayer().GetHunger() / _parkViewModel.GetPlayer().GetHungerLimit()));
        _mentalityProgressBar.setValue((int) (100 * _parkViewModel.GetPlayer().GetMentality() / 100));
    }

    public Object[] goTown() {
        Random rand = new Random();
        int maxHealthLeft = 30;
        int HealthLeft = rand.nextInt(maxHealthLeft); // on soustraira ce resultat à la vie actuelle du zombie

        int maxHungerLeft = 40;
        int HungerLeft = rand.nextInt(maxHungerLeft);

        float actualHealth = _parkViewModel.GetPlayer().GetHealth();
        float actualHunger = _parkViewModel.GetPlayer().GetHunger();

        float Health = actualHealth - HealthLeft;
        float Hunger = actualHunger - HungerLeft;

        if (Hunger <= 0) {
            Hunger = 0;
        }

        return new Object[]{Health, Hunger};

    }


    @Override
    public void Draw(SpriteBatch spriteBatch) {
        // DRAW textures (images), play sound, ...
        _background.draw(spriteBatch);

        _buttonFeed.draw(spriteBatch);
        _buttonAmuse.draw(spriteBatch);
        _buttonTown.draw(spriteBatch);
        _buttonMusic.draw(spriteBatch);

        _healthProgressBar.Draw(spriteBatch);
        _hungryProgressBar.Draw(spriteBatch);
        _mentalityProgressBar.Draw(spriteBatch);

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
        _buttonMusicTexture.dispose();
    }
}
