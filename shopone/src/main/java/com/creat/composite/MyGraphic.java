package com.creat.composite;

import java.util.List;

/**
 * Created by Administrator on 2017/7/20 0020.
 */
public abstract class MyGraphic {
    protected abstract void draw();
    protected abstract void add(MyGraphic myGraphic);
    protected abstract void remove(MyGraphic myGraphic);
}
