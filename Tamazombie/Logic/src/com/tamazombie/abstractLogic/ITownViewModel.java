package com.tamazombie.abstractLogic;

import com.tamazombie.abstractModel.IPlayer;

/**
 * Created with IntelliJ IDEA.
 * User: David Bottiau
 * Date: 02/04/14
 * Time: 13:31
 * To change this template use File | Settings | File Templates.
 */
public interface ITownViewModel extends IViewModel {
    public IPlayer GetPlayer();

    public void AddEnemy();
    public void Fight();
    public void Reply();
}
