package com.creat.proxy;

/**
 * Created by Administrator on 2017/7/21 0021.
 */
public class Client {
    public static void main(String[] args){
        Proxy proxy = new Proxy(new RealSubject());
        proxy.sell();
    }
}
