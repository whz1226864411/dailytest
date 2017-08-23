package com.creat.sort;


/**
 * Created by whz on 2017/8/22.
 */
public class InsertionSort {

    public static void main(String[] args){
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
        for(int i = 1; i < length; i++){
            for(int n = i-1; n >= 0; n--){
                if(array[n].compareTo(array[n+1]) > 0){
                    temp = array[n];
                    array[n] = array[n+1];
                    array[n+1] = temp;
                }else {
                    break;
                }
            }
        }
    }
}
