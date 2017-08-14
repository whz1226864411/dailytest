package com.creat.chain;

/**
 * Created by Administrator on 2017/7/21 0021.
 */
public abstract class Hander {
    private Hander hander;

    public Hander getHander() {
        return hander;
    }

    public void setHander(Hander hander) {
        this.hander = hander;
    }

    public abstract void doHander();
}
