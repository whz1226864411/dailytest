package com.creat.chain;

/**
 * Created by Administrator on 2017/7/21 0021.
 */
public class Client {
    public static void main(String[] args){
        Hander hander = new ConcreteHandler();
        Hander hander1 = new ConcreteHandler();
        hander.setHander(hander1);
        hander.doHander();
    }
}
