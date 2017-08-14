package com.creat.bridge;

/**
 * Created by Administrator on 2017/7/20 0020.
 */
public class Cilent {
    public static void main(String[] args){
        Window window = new OneWindow(new WinDrawToolImpl());
        window.drawWindow();
    }
}
