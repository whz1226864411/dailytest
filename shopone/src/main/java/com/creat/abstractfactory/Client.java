package com.creat.abstractfactory;

/**
 * Created by Administrator on 2017/7/13 0013.
 */
public class Client {
    public static void main(String[] args){
        ProduceFactory produceFactory = new ChineseFactory();
        produceFactory.productFruit().show();
        produceFactory.productMeat().show();
    }
}
