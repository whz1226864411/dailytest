package com.creat.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/7/29 0029.
 */
public class ManProxy implements InvocationHandler {
    private Object proxied;
    public ManProxy(Object proxied){
        this.proxied = proxied;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("启动代理");
        return method.invoke(proxied,args);
    }
}
