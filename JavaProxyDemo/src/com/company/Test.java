package com.company;

/**
 * Created by allen on 2016/9/6.
 */
public class Test {

    public static void main(String[] args)
    throws Exception{
        Dog target = new GunDog();
        Dog dog = (Dog) MyProxyFactory.getProxy(target);
        dog.run();
        dog.info();
    }
}
