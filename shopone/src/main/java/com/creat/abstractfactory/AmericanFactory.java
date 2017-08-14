package com.creat.abstractfactory;

/**
 * Created by Administrator on 2017/7/13 0013.
 */
public class AmericanFactory implements ProduceFactory{
    public Meat productMeat() {
        return new AmericanMeat();
    }

    public Fruit productFruit() {
        return new AmericanFruit();
    }
}
