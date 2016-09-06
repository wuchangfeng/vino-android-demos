package com.company;

import java.lang.reflect.Proxy;

/**
 * Created by allen on 2016/9/6.
 */
public class MyProxyFactory {

    public static Object getProxy(Object target)
    throws Exception{
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.setTarget(target);
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
            target.getClass().getInterfaces(),handler);
    }
}
