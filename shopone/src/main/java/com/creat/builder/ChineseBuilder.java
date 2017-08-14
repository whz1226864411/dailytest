package com.creat.builder;

/**
 * Created by Administrator on 2017/7/13 0013.
 */
public class ChineseBuilder extends CarBuilder{
    public void buildCar() {
        this.car = new Car();
    }

    public void buildColor() {
        this.car.color = "red";
    }

    public void buildLength() {
        this.car.length = 18;
    }

    public Car getCar() {
        return this.car;
    }
}
