package com.tamazombie.concreteIoC;

import com.tamazombie.abstractIoC.IIocContainer;
import com.tamazombie.concreteLogic.ParkViewModel;
import com.tamazombie.concreteModel.ZombiePlayer;
import com.tamazombie.concreteView.TownView;
import com.tamazombie.portableServices.NavigationService;
import com.tamazombie.concreteServices.StorageService;
import com.tamazombie.concreteView.Background;
import com.tamazombie.concreteView.Button;
import com.tamazombie.concreteView.ParkView;
import org.picocontainer.Characteristics;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;
import org.picocontainer.behaviors.OptInCaching;

/**
 * Created with IntelliJ IDEA.
 * User: David Bottiau
 * Date: 12/03/14
 * Time: 11:20
 * To change this template use File | Settings | File Templates.
 */
final class IoCPicoContainer implements IIocContainer {
    /**
     *  Holder for the IoCPicoContainer singleton
     */
    private static class IoCPicoContainerHolder
    {
        // Unique instance non pre-initialized
        private final static IoCPicoContainer instance = new IoCPicoContainer();
    }

    private IoCPicoContainer() {
        // Initialize Dependency Injection
        InitializeContainers();
        AddComponents();
    }

    /**
     * Get the singleton of the current class
     * @return The single instance of IoCPicoContainer
     */
    public static IoCPicoContainer getInstance() {
        return IoCPicoContainerHolder.instance;
    }



    /**
     * The IoC container to create Singletons or Factories
     */
    private MutablePicoContainer _picoContainer;


    /**
     * Initialize IoC containers
     */
    private void InitializeContainers() {
        _picoContainer = new DefaultPicoContainer(new OptInCaching());
    }

    /**
     * Register Dependency Injection with PicoContainer
     */
    private void AddComponents() {
        // Register Model
        _picoContainer.as(Characteristics.CACHE).addComponent(ZombiePlayer.class);

        // Register Logic (ViewModels)
        _picoContainer.as(Characteristics.CACHE).addComponent(ParkViewModel.class);

        // Register Services
        _picoContainer.as(Characteristics.CACHE).addComponent(StorageService.class);
        _picoContainer.as(Characteristics.CACHE).addComponent(NavigationService.class);

        // Register View
        _picoContainer.as(Characteristics.CACHE).addComponent(ParkView.class);
        _picoContainer.as(Characteristics.CACHE).addComponent(TownView.class);

        // Register View objects
        _picoContainer.addComponent(Button.class);
        _picoContainer.addComponent(Background.class);
    }

    /**
     * Get the PicoContainer
     * @return The PicoContainer expected
     */
    private MutablePicoContainer GetPico() {
        return _picoContainer;
    }

    /**
     * Return an instance expected by the type of the object
     * @param type Type of the instance
     * @return The instance expected
     */
    public <T> T GetInstance(Class<T> type) {
        MutablePicoContainer pico = GetPico();
        return pico.getComponent(type);
    }
}
