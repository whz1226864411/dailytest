package com.creat.composite;

/**
 * Created by Administrator on 2017/7/20 0020.
 */
public class MyText extends MyGraphic{
    protected void draw() {
        System.out.println("我写了个字");
    }

    protected void add(MyGraphic myGraphic) {

    }

    protected void remove(MyGraphic myGraphic) {

    }
}
