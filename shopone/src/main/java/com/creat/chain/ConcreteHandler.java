package com.creat.chain;

/**
 * Created by Administrator on 2017/7/21 0021.
 */
public class ConcreteHandler extends Hander{
    public void doHander() {
        if (getHander() != null){
            getHander().doHander();
            System.out.println("放过");
        }else {
            System.out.println("自己处理");
        }
    }
}
