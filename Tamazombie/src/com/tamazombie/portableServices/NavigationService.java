package com.tamazombie.portableServices;

import com.tamazombie.abstractView.IGameView;
import com.tamazombie.abstractView.IParkView;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: David Bottiau
 * Date: 25/03/14
 * Time: 09:54
 * To change this template use File | Settings | File Templates.
 */
public class NavigationService implements INavigationService {
    private Stack<IGameView> _views;

    public NavigationService(IParkView parkView){
        _views = new Stack<IGameView>();
        _views.push(parkView);
    }

    @Override
    public IGameView GetView() {
        return _views.get(_views.size() - 1);
    }

    @Override
    public <T> void Navigate(Class<T> type) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void GoBack() {
        // Cannot go back if it exists only one view
        if (_views.size() <= 1)
            return;

        // set the previous view

        // and remove actual view
    }

    @Override
    public void Close() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
