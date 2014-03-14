package com.tamazombie.abstractLogic;

import com.tamazombie.abstractModel.IPlayer;

/**
 * Created with IntelliJ IDEA.
 * User: David Bottiau
 * Date: 11/03/14
 * Time: 23:04
 * To change this template use File | Settings | File Templates.
 */
public interface IParkViewModel {
    public IPlayer GetPlayer();

    public void PlayerMove();
    public void PlayerHungry();
    public void PlayerEat();
    public void PlayerDivert();
    public void PlayerDie();
    public void GoToTown();
}
