package com.tamazombie.concreteLogic;

import com.tamazombie.abstractLogic.ITownViewModel;
import com.tamazombie.abstractModel.IPlayer;

/**
 * Created with IntelliJ IDEA.
 * User: David Bottiau
 * Date: 02/04/14
 * Time: 18:34
 * To change this template use File | Settings | File Templates.
 */
public class TownViewModel implements ITownViewModel {
    private IPlayer _player;

    public TownViewModel(IPlayer player){
        _player = player;
    }

    @Override
    public IPlayer GetPlayer() {
        return _player;
    }

    @Override
    public void AddEnemy() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void Fight() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void Reply() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
