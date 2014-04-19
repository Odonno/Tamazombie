package com.tamazombie.abstractView;

import com.tamazombie.abstractLogic.IParkViewModel;

/**
 * Created with IntelliJ IDEA.
 * User: David Bottiau
 * Date: 16/03/14
 * Time: 11:46
 * To change this template use File | Settings | File Templates.
 */
public interface IParkView extends IGameView {
    public IParkViewModel GetParkViewModel();
}
