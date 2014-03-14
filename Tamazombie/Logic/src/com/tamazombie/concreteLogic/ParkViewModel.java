package com.tamazombie.concreteLogic;

import com.tamazombie.abstractLogic.IParkViewModel;
import com.tamazombie.abstractModel.IPlayer;

/**
 * Created with IntelliJ IDEA.
 * User: David Bottiau
 * Date: 11/03/14
 * Time: 23:04
 * To change this template use File | Settings | File Templates.
 */
public final class ParkViewModel implements IParkViewModel {
    private IPlayer _player;

    public ParkViewModel(IPlayer player){
        _player = player;
    }

    @Override
    public IPlayer GetPlayer() {
        return _player;
    }

    @Override
    public void PlayerMove() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void PlayerHungry() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void PlayerEat() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void PlayerDivert() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void PlayerDie() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void GoToTown() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
