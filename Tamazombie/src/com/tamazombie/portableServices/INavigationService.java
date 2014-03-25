package com.tamazombie.portableServices;

import com.tamazombie.abstractView.IGameView;

/**
 * Created with IntelliJ IDEA.
 * User: David Bottiau
 * Date: 25/03/14
 * Time: 09:53
 * To change this template use File | Settings | File Templates.
 */
public interface INavigationService {
    IGameView GetView();

    void Navigate();
    void GoBack();
    void Close();
}
