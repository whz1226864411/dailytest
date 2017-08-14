package com.creat.decorator;

/**
 * Created by Administrator on 2017/7/20 0020.
 */
public abstract class Decorator implements Component{

    private Component component;
    public Decorator(Component component){
        this.component = component;
    }
    public void show() {
        this.component.show();
    }
}
