package com.creat.builder;

/**
 * Created by Administrator on 2017/7/13 0013.
 */
public class Client {
    public static void main(String[] args){
        CarBuilder carBuilder = new ChineseBuilder();
        carBuilder.buildCar();
        carBuilder.buildColor();
        carBuilder.buildLength();
        Car car = carBuilder.getCar();
        System.out.println(car);
    }
}
