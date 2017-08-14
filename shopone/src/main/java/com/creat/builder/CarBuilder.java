package com.creat.builder;


/**
 * Created by Administrator on 2017/7/13 0013.
 */
public abstract class CarBuilder {
    protected Car car;
    public abstract void buildCar();
    public abstract void buildColor();
    public abstract void buildLength();
    public abstract Car getCar();
}
