package com.creat.logintest;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Administrator on 2017/10/3.
 */
public class Main {

    public static void main(String[] args){
        try {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread one = new Thread(new LoginTest("05156001",countDownLatch));
            one.start();
//            Thread two = new Thread(new LoginTest("05156031",countDownLatch));
//            two.start();
//            Thread three = new Thread(new LoginTest("05156061",countDownLatch));
//            three.start();
//            Thread four = new Thread(new LoginTest("05156091",countDownLatch));
//            four.start();
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
