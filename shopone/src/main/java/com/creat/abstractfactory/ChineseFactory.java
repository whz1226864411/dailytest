package com.creat.abstractfactory;

/**
 * Created by Administrator on 2017/7/13 0013.
 */
public class ChineseFactory implements ProduceFactory {
    public Meat productMeat() {
        return new ChineseMeat();
    }

    public Fruit productFruit() {
        return new ChineseFruit();
    }
}
