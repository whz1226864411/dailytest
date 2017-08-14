package com.creat.bridge;

/**
 * Created by Administrator on 2017/7/20 0020.
 */
public abstract class Window {
    protected DrawToolImpl drawTool;
    public Window(DrawToolImpl drawTool){
        this.drawTool = drawTool;
    }
    public abstract void drawWindow();
}
