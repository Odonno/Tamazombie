package com.tamazombie.abstractIoC;

import com.tamazombie.portableIoC.IoCType;

/**
 * Created with IntelliJ IDEA.
 * User: David Bottiau
 * Date: 12/03/14
 * Time: 11:22
 * To change this template use File | Settings | File Templates.
 */
public interface IIocContainer {
    public <T> T GetInstance(Class<T> type, IoCType ioCType);
}
