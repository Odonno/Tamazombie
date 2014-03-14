package com.tamazombie.concreteIoC;

import com.tamazombie.abstractIoC.IIocContainer;
import com.tamazombie.concreteLogic.ParkViewModel;
import com.tamazombie.concreteModel.ZombiePlayer;
import com.tamazombie.concreteServices.StorageService;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;
import org.picocontainer.behaviors.Caching;

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
     * The IoC container to create Singletons
     */
    private MutablePicoContainer _singletonPicoContainer;

    /**
     * The IoC container to create Factories
     */
    private MutablePicoContainer _factoryPicoContainer;


    /**
     * Initialize IoC containers
     */
    private void InitializeContainers() {
        _factoryPicoContainer = new DefaultPicoContainer();
        _singletonPicoContainer = new DefaultPicoContainer(new Caching());
    }

    /**
     * Register Dependency Injection with PicoContainer
     */
    private void AddComponents() {
        // Register Model
        _singletonPicoContainer.addComponent(ZombiePlayer.class);

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
    private MutablePicoContainer GetPico(IoCType type) {
        return (IoCType.Singleton == type) ? _singletonPicoContainer : _factoryPicoContainer;
    }

    /**
     * Return an instance expected by the type of the object and the IoCType
     * @param type Type of the instance
     * @param ioCType IoCType expected by the user (to create a new object)
     * @return The instance expected
     */
    public <T> T GetInstance(Class<T> type, IoCType ioCType) {
        MutablePicoContainer pico = GetPico(ioCType);
        return pico.getComponent(type);
    }
}
