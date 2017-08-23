package com.creat.sort;

import org.junit.Test;

/**
 * Created by whz on 2017/8/22.
 */
public class ShellSort {

    @Test
    public void test(){
        Integer[] array = new Integer[]{10,54,55,47,50,20,41,33,40,70};
        sort(array);
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    public static <T extends Comparable<? super T>> void sort(T[] array){
        int length = array.length;
        T temp = null;
        for(int i = length/2; i >= 1; i /= 2){
            for(int x = i; x < length; x++){
                for(int y = x - i; y >= 0; y -= i){
                    if(array[y].compareTo(array[y+i]) > 0){
                        temp = array[y];
                        array[y] = array[y+i];
                        array[y+i] = temp;
                    }else {
                        break;
                    }
                }
            }
        }
    }
}
