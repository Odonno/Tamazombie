package com.tamazombie.portableGame;

import com.tamazombie.concreteLogic.ParkViewModel;
import com.tamazombie.concreteModel.Player;
import com.tamazombie.concreteServices.StorageService;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;
import org.picocontainer.behaviors.Cached;
import org.picocontainer.behaviors.Caching;

/**
 * Created with IntelliJ IDEA.
 * User: David Bottiau
 * Date: 12/03/14
 * Time: 01:15
 * To change this template use File | Settings | File Templates.
 */
public class IoC {
    /**
     * The IoC container to create Singletons
     */
    private static MutablePicoContainer _singletonPicoContainer;

    /**
     * The IoC container to create Factories
     */
    private static MutablePicoContainer _factoryPicoContainer;


    static {
        // Initialize Dependency Injection
        InitializeContainers();
        AddComponents();
    }


    /**
     * Initialize IoC containers
     */
    private static void InitializeContainers() {
        _factoryPicoContainer = new DefaultPicoContainer();
        _singletonPicoContainer = new DefaultPicoContainer(new Caching());
    }

    /**
     * Register Dependency Injection with PicoContainer
     */
    private static void AddComponents() {
        // Register Model
        _singletonPicoContainer.addComponent(Player.class);

        // Register Logic (ViewModels)
        _singletonPicoContainer.addComponent(ParkViewModel.class);

        // Register Services
        _singletonPicoContainer.addComponent(StorageService.class);
    }

    /**
     * Get the PicoContainer that correspond to the IoCType expected
     * @param type IoCType expected by the user (to create a new object)
     * @return The PicoContainer expected
     */
    public static MutablePicoContainer GetPico(IoCType type) {
         return (IoCType.Singleton == type) ? _singletonPicoContainer : _factoryPicoContainer;
    }
}