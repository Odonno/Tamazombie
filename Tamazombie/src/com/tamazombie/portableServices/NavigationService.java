package com.tamazombie.portableServices;

import com.tamazombie.abstractView.IGameView;
import com.tamazombie.abstractView.IParkView;
import com.tamazombie.concreteIoC.IoC;
import com.tamazombie.concreteIoC.IoCType;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: David Bottiau
 * Date: 25/03/14
 * Time: 09:54
 * To change this template use File | Settings | File Templates.
 */
public final class NavigationService implements INavigationService {
    private Stack<IGameView> _views;

    public NavigationService(){
        _views = new Stack<IGameView>();
    }

    @Override
    public IGameView GetView() {
        return _views.peek();
    }

    @Override
    public <T> void Navigate(Class<T> type) {
        // Get the view and add it
        T _view = IoC.GetInstance(type);
        _views.push((IGameView) _view);

        // Create the view
        _views.peek().Create();
    }

    @Override
    public void GoBack() {
        // Cannot go back if it exists only one view
        if (_views.size() <= 1)
            return;

        // remove actual view and dispose components of the view
        DisposeView(_views.pop());
    }

    @Override
    public void Close() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void Dispose() {
        while (!_views.empty()){
            DisposeView(_views.pop());
        }
    }

    private void DisposeView(IGameView view){
         //view.Dispose();
    }
}
