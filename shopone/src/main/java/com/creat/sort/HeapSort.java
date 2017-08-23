package com.creat.sort;

import org.junit.Test;

/**
 * Created by whz on 2017/8/23.
 */
public class HeapSort {

    @Test
    public void test(){
        Integer[] array = new Integer[]{10,54,55,47,50,20,41,33,40,28,70};
        //Integer[] array = new Integer[]{29,39,40,59,58,51,56};
        Integer[] newArray = new Integer[array.length+1];
        buildHeap(array,newArray);
        sort(newArray,array);
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
    public static <T extends Comparable<? super T>> void sort(T[] array,T[] newArray){
        int length = array.length;
        for(int i = 0; i < newArray.length; i++){
            newArray[i] = deleteMin(array,newArray.length -i );
        }
    }

    public static <T extends Comparable<? super T>> void buildHeap(T[] array,T[] newArray){
        newArray[0] = null;
        for(int i = 1; i <= array.length; i++){
            insert(newArray,array[i-1],i);
        }
    }

    private static <T extends Comparable<? super T>> T deleteMin(T[] array,int size){
        T result = array[1];
        array[1] = null;
        int index = 1;
        while(index*2 < array.length-1 && array[index*2] != null ){
            if(array[index*2+1] == null || array[index*2].compareTo(array[index*2+1]) < 0){
                array[index] = array[index*2];
                index *= 2;
            }else{
                array[index] = array[index*2+1];
                index = index*2+1;
            }
        }
        insert(array,array[size],index);
        array[size] = null;
        return result;
    }
    private static <T extends Comparable<? super T>> void insert(T[] array,T value,int place){
        if(((double)place)/2%1 == 0){
            int index = place;
            if(index!=1 && array[index/2].compareTo(value) > 0 ){
                array[index] = array[index/2];
                insert(array,value,index/2);
            }else {
                array[index] = value;
            }
        }else {
            int index = place;
            if (index!=1 && array[(index-1)/2].compareTo(value) > 0 ){
                array[index] = array[(index-1)/2];
                insert(array,value,(index-1)/2);
            }else {
                array[index] = value;
            }
        }
    }
}
