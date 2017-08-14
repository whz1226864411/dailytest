package com.creat.proxy;

/**
 * Created by Administrator on 2017/7/21 0021.
 */
public class Proxy implements Subject{
    private Subject subject;
    public Proxy(Subject subject){
        this.subject = subject;
    }
    public void sell() {
        subject.sell();
        System.out.println("加价10元");
    }
}
