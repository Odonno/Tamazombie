package com.tamazombie.concreteView;

import com.tamazombie.abstractLogic.IParkViewModel;
import com.tamazombie.abstractLogic.IViewModel;
import com.tamazombie.abstractView.IGameView;

/**
 * Created with IntelliJ IDEA.
 * User: David Bottiau
 * Date: 12/03/14
 * Time: 13:48
 * To change this template use File | Settings | File Templates.
 */
public class ParkView implements IGameView {
    private IParkViewModel _parkViewModel;

    public ParkView(IParkViewModel parkViewModel){
        _parkViewModel = parkViewModel;
    }

    @Override
    public IViewModel GetViewModel() {
        return _parkViewModel;
    }
}
