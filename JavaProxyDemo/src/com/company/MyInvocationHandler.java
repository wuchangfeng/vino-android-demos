package com.company;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by allen on 2016/9/6.
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

       DogUtil du = new DogUtil();
        du.method1();
        Object result = method.invoke(target,args);
        du.method2();
        return result;
    }
}
