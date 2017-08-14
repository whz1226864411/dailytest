package com.creat.composite;

import java.util.List;

/**
 * Created by Administrator on 2017/7/20 0020.
 */
public class MyPicture extends MyGraphic{

    private List<MyGraphic> list;
    protected void draw() {
        System.out.println("显示张图片");
    }

    protected void add(MyGraphic myGraphic) {
        list.add(myGraphic);
    }

    protected void remove(MyGraphic myGraphic) {
        list.remove(myGraphic);
    }
}
