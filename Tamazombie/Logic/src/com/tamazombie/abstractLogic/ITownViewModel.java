package com.tamazombie.abstractLogic;

import com.tamazombie.abstractModel.IEnemy;
import com.tamazombie.abstractModel.IPlayer;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: David Bottiau
 * Date: 02/04/14
 * Time: 13:31
 * To change this template use File | Settings | File Templates.
 */
public interface ITownViewModel extends IViewModel {
    public IPlayer GetPlayer();
    public List<IEnemy> GetEnemies();

    public void AddEnemy();
    public void Fight();
    public void Reply();
}
