package com.creat.bridge;

/**
 * Created by Administrator on 2017/7/20 0020.
 */
public class TwoWindow extends Window{

    public TwoWindow(DrawToolImpl drawTool) {
        super(drawTool);
    }

    public void drawWindow() {
        this.drawTool.drawBorder();
    }
}
