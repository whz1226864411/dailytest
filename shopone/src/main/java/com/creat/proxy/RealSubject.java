package com.creat.proxy;

/**
 * Created by Administrator on 2017/7/21 0021.
 */
public class RealSubject implements Subject{
    public void sell() {
        System.out.println("十块钱");
    }
}
