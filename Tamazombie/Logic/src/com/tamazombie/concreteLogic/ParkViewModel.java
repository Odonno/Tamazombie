package com.tamazombie.concreteLogic;

import com.tamazombie.abstractLogic.IParkViewModel;
import com.tamazombie.abstractModel.IPlayer;
import com.tamazombie.commonModel.Direction;
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
    private float _mentalityRatePerSecond = 0.6f;
    private float _activity = 20;
    private float _nextTimeDirection;
    private float _speed = 20f;

    public ParkViewModel(IPlayer player) {
        _player = player;
        CalculateNextTimeDirection();
    }

    @Override
    public IPlayer GetPlayer() {
        return _player;
    }

    @Override
    public void PlayerMove(float deltaTime) {
        // update position of player
        _player.setPosition(_player.getX() + (deltaTime * _speed * _player.GetDirection().GetX()), _player.getY() + (deltaTime * _speed * _player.GetDirection().GetY()));

        _nextTimeDirection -= deltaTime;
        CalculateNextTimeDirection();

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

    public void PlayerMentality(float deltaTime) {
        _player.SetMentality(_player.GetMentality() - (deltaTime * _mentalityRatePerSecond));
    }

    @Override
    public void PlayerDivert(float deltaTime) {
        _player.SetMentality(_player.GetMentality() + _activity);
        if (_player.GetMentality() > 100)
            _player.SetMentality(100);
    }

    @Override
    public void GoToTown() {
        // TODO : Go to ITownView using Navigation Service
    }


    private void CalculateNextTimeDirection() {
        // Give a new direction after each timer ended
        if (_nextTimeDirection <= 0f) {
            _nextTimeDirection = (float) (Math.random() * 4 + 1);

            // Set a new direction for the player
            int newDirectionIndex = (int) Math.floor(Math.random() * Direction.values().length);
            Direction newDirection = Direction.values()[newDirectionIndex];
            _player.SetDirection(newDirection);
        }

        // Give a good direction if the player will be out of the screen
        if (_player.getX() < 0)
            _player.SetDirection(Direction.Right);
        if (_player.getY() < 0)
            _player.SetDirection(Direction.Down);
        if (_player.getX() >= 800)
            _player.SetDirection(Direction.Left);
        if (_player.getY() >= 480)
            _player.SetDirection(Direction.Top);
    }
}
