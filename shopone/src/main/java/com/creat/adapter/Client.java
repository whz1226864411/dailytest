package com.creat.adapter;

/**
 * Created by Administrator on 2017/7/20 0020.
 */
public class Client {
    public static void main(String[] args){
        Target target = new TwoAdapter();
        target.twohole();
    }
}
