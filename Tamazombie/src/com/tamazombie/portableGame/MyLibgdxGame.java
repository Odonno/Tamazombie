package com.tamazombie.portableGame;

import com.badlogic.gdx.Game;
import com.tamazombie.concreteLogic.ParkViewModel;
import com.tamazombie.concreteModel.Player;
import com.tamazombie.concreteServices.StorageService;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;
import org.picocontainer.behaviors.Caching;

/**
 * Created with IntelliJ IDEA.
 * User: David Bottiau
 * Date: 11/03/14
 * Time: 19:52
 * To change this template use File | Settings | File Templates.
 */

public class MyLibgdxGame extends Game {
    /**
     * The IoC container to create Singletons
     */
    private MutablePicoContainer _singletonPicoContainer;

    /**
     * The IoC container to create Factories
     */
    private MutablePicoContainer _factoryPicoContainer;

    @Override
    public void create() {
        // Initialize Dependency Injection
        InitializeContainers();
        AddComponents();

        // TODO : use PicoContainer in modules (Logic, Services or here in Main)
    }

    /**
     * Initialize IoC containers
     */
    private void InitializeContainers( ){
        _factoryPicoContainer = new DefaultPicoContainer();
        _singletonPicoContainer = new DefaultPicoContainer(new Caching());
    }

    /**
     * Register Dependency Injection with PicoContainer
     */
    private void AddComponents() {
        // Register Model
        _singletonPicoContainer.addComponent(Player.class);

        // Register Logic (ViewModels)
        _singletonPicoContainer.addComponent(ParkViewModel.class);

        // Register Services
        _singletonPicoContainer.addComponent(StorageService.class);
    }
}
