package com.tamazombie.abstractLogic;

import com.tamazombie.abstractModel.IPlayer;

/**
 * Created with IntelliJ IDEA.
 * User: David Bottiau
 * Date: 11/03/14
 * Time: 23:04
 * To change this template use File | Settings | File Templates.
 */

public interface IParkViewModel extends IViewModel {
    public IPlayer GetPlayer();

    public void PlayerMove(float deltaTime);
    public void PlayerHungry(float deltaTime);
    public void PlayerEat(float deltaTime);
    public void PlayerDivert(float deltaTime);
    public void GoToTown();
}
