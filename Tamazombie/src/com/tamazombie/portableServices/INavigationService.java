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

    public <T> void Navigate(Class<T> type);
    public void GoBack();
    public void Close();
    public void Dispose();
}
