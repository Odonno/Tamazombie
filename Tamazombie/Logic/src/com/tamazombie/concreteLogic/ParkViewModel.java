package com.tamazombie.concreteLogic;

import com.tamazombie.abstractLogic.IParkViewModel;
import com.tamazombie.abstractModel.IPlayer;
import com.tamazombie.commonModel.GameMode;

/**
 * Created with IntelliJ IDEA.
 * User: David Bottiau
 * Date: 11/03/14
 * Time: 23:04
 * To change this template use File | Settings | File Templates.
 */
public final class ParkViewModel implements IParkViewModel {
    private IPlayer _player;
    private float _hungryRatePerSecond = 0.5f;
    private float _hungryByMeal = 50f;
    private float _healByMeal = 10f;
    private float _damagePerSecond = 1f;

    public ParkViewModel(IPlayer player){
        _player = player;
    }

    @Override
    public IPlayer GetPlayer() {
        return _player;
    }

    @Override
    public void PlayerMove(float deltaTime) {
        // TODO : update position of player

        // Check if the player died and he received damages each time his hungry limit overcame
        if (_player.GetGameMode() == GameMode.ZombieMode && _player.GetHunger() >= _player.GetHungerLimit())
            _player.SetHealth(_player.GetHealth() + _damagePerSecond);
        if (_player.GetGameMode() == GameMode.HumanMode && _player.GetHunger() <= _player.GetHungerLimit())
            _player.SetHealth(_player.GetHealth() - _damagePerSecond);
    }

    @Override
    public void PlayerHungry(float deltaTime) {
        if (_player.GetGameMode() == GameMode.ZombieMode)
            _player.SetHunger(_player.GetHunger() + (deltaTime * _hungryRatePerSecond));
        if (_player.GetGameMode() == GameMode.HumanMode)
            _player.SetHunger(_player.GetHunger() - (deltaTime * _hungryRatePerSecond));
    }

    @Override
    public void PlayerEat(float deltaTime) {
        if (_player.GetGameMode() == GameMode.ZombieMode)
            _player.SetHunger(_player.GetHunger() - _hungryByMeal);
        if (_player.GetGameMode() == GameMode.HumanMode)
            _player.SetHunger(_player.GetHunger() + _hungryByMeal);

        _player.SetHealth(_player.GetHealth() + _healByMeal);
    }

    @Override
    public void PlayerDivert(float deltaTime) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void GoToTown() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
