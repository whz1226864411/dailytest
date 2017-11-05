package com.creat.suoxie;

import org.junit.Test;

/**
 * Created by whz on 2017/9/24.
 */
public class Abbr {

    public String abbr(String arr){
        String[] array = arr.split(" ");
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < array.length; i++){
            String s = array[i];
            if(!s.equalsIgnoreCase("and")&&!s.equals("for")&&!s.equals("the")&&s.length()>=3){
                result.append(s.toUpperCase().charAt(0));
            }
        }
        return result.toString();
    }
    @Test
    public void test(){
        Abbr abbr = new Abbr();
        System.out.println(abbr.abbr("The load of the Rings"));
    }
}

