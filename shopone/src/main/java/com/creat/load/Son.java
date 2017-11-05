package com.creat.load;

/**
 * Created by Administrator on 2017/10/30.
 */
public class Son extends SuperClass{
    public Son(){
        System.out.println("bbb");
    }
    public final void add(){

    }
    public final void add(int a){

    }
    public static void main(String[] args){
        new Son().add(1);
    }
}
