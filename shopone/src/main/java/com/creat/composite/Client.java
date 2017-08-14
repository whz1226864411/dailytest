package com.creat.composite;

/**
 * Created by Administrator on 2017/7/20 0020.
 */
public class Client {
    public static void main(String[] args){
        MyGraphic myGraphic = new MyPicture();
        myGraphic.add(new MyLine());
        myGraphic.add(new MyPicture());
    }
}
