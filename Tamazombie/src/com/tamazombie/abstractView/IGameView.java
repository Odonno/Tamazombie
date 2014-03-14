package com.tamazombie.abstractView;

import com.tamazombie.abstractLogic.IViewModel;

/**
 * Created with IntelliJ IDEA.
 * User: David Bottiau
 * Date: 12/03/14
 * Time: 13:48
 * To change this template use File | Settings | File Templates.
 */
public interface IGameView {
    public IViewModel GetViewModel();

    public void Update();
    public void Draw();
}
