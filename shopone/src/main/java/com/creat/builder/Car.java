package com.creat.builder;

/**
 * Created by Administrator on 2017/7/13 0013.
 */
public class Car {
    protected String color;
    protected Integer length;

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", length=" + length +
                '}';
    }
}
