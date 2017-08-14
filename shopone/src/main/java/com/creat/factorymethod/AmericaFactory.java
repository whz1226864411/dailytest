package com.creat.factorymethod;

/**
 * Created by Administrator on 2017/7/13 0013.
 */
public class AmericaFactory extends CarFactory{
    Car productCar() {
        return new AmericaCar();
    }
}
