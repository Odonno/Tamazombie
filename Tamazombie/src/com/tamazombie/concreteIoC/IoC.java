package com.tamazombie.concreteIoC;

import com.tamazombie.abstractIoC.IIocContainer;

/**
 * Created with IntelliJ IDEA.
 * User: David Bottiau
 * Date: 12/03/14
 * Time: 01:15
 * To change this template use File | Settings | File Templates.
 */
public final class IoC {
    /**
     * IoCContainer used to create instances
     */
    private static IIocContainer _iocContainer = IoCPicoContainer.getInstance();

    private IoC() { }

    /**
     * Return an instance expected by the type of the object (with the factory pattern)
     * @param type Type of the instance
     * @return A new instance expected
     */
    public static <T> T GetInstance(Class<T> type) {
        return _iocContainer.GetInstance(type, IoCType.Factory);
    }

    /**
     * Return an instance expected by the type of the object and the IoCType
     * @param type Type of the instance
     * @param ioCType IoCType expected by the user (to create a new object)
     * @return The instance expected
     */
    public static <T> T GetInstance(Class<T> type, IoCType ioCType) {
        return _iocContainer.GetInstance(type, ioCType);
    }
}