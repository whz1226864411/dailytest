package com.creat.decorator;

/**
 * Created by Administrator on 2017/7/20 0020.
 */
public class BoardDecorator extends Decorator {
    public BoardDecorator(Component component) {
        super(component);
    }
    @Override
    public void show(){
        super.show();
        drawBoard();
    }

    public void drawBoard(){
        System.out.println("我画了一条边");
    }
}
