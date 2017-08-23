package com.creat.sort;

import org.junit.Test;

/**
 * Created by Administrator on 2017/8/23.
 */
public class MergeSort {
    @Test
    public void test(){
        Integer[] array = new Integer[]{10,54,55,47,50,20,41,33,40,28,70,27};
        Integer[] newArray = new Integer[array.length];
        sort(array,newArray,0,array.length-1);
        for(int i = 0; i < newArray.length; i++){
            System.out.print(newArray[i]+" ");
        }
        System.out.println();
    }
    public static <T extends Comparable<? super T>> void sort(T[] array,T[] newArray, int left, int right){
        if(right > left){
            int middle = ( right + left ) / 2;
            T[] l = (T[]) new Comparable[middle - left + 1];
            T[] r = (T[]) new Comparable[right - middle];
            sort(array, l, left, middle);
            sort(array, r, middle+1, right);
            mergeSort(l, r, newArray);
        }else {
            newArray[0]=array[right];
        }
    }

    private static <T extends Comparable<? super T>> void mergeSort(T[] l, T[] r, T[] newArray){
        int left = 0;
        int right = 0;
        for(int i = 0;i < newArray.length; i++){
            if(left >= l.length){
                newArray[i] = r[right++];
            }else if(right >= r.length){
                newArray[i] = l[left++];
            }else if(l[left].compareTo(r[right]) < 0 ){
                newArray[i] = l[left++];
            }else {
                newArray[i] = r[right++];
            }
        }
    }
}
