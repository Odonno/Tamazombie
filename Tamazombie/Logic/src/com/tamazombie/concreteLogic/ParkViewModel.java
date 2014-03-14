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

    @Override
    public IPlayer getPlayer() {
        return _player;
    }
}
