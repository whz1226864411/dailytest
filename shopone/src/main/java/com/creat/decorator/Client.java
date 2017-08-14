package com.creat.decorator;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by Administrator on 2017/7/20 0020.
 */
public class Client {
    public static void main(String[] args) throws FileNotFoundException {
        Component component = new ColorDecorator(new BoardDecorator(new Window()));
        component.show();
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(new File("")));
    }
}
