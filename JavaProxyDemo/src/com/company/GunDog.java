package com.company;

/**
 * Created by allen on 2016/9/6.
 */
public class GunDog implements Dog {

    public void info(){
        System.out.println("我是一只狗");
    }

    @Override
    public void run() {
        System.out.println("我会跑");
    }
}
