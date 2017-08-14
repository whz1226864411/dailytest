package com.creat.decorator;

/**
 * Created by Administrator on 2017/7/20 0020.
 */
public class ColorDecorator extends Decorator{
    public ColorDecorator(Component component) {
        super(component);
    }
    @Override
    public void show(){
        super.show();
        drawColor();
    }

    public void drawColor(){
        System.out.println("我涂上了红色");
    }
}
