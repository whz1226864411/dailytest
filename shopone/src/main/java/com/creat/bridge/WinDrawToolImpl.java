package com.creat.bridge;

/**
 * Created by Administrator on 2017/7/20 0020.
 */
public class WinDrawToolImpl implements DrawToolImpl{
    public void drawLine() {
        System.out.println("windows下的线");
    }

    public void drawBorder() {
        System.out.println("windows下的边框");
    }
}
