package com.creat.exception;

/**
 * Created by Administrator on 2017/7/30 0030.
 */
public class Exception {
    public static void main(String[] args){
        System.out.println(get());
    }
    public static int get(){
        int x = 1;
        try {
            x = 2 ;
            x /= 0 ;
            return x;
        }catch (java.lang.Exception e){

            return x;
        }finally {
            x = 4;
        }

    }
}
