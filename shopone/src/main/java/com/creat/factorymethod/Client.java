package com.creat.factorymethod;

/**
 * Created by Administrator on 2017/7/13 0013.
 */
public class Client {
    public static void main(String[] args){
        CarFactory carFactory = new AmericaFactory();
        carFactory.productCar().run();
        carFactory = new ChinaFactory();
        carFactory.productCar().run();
    }
}
