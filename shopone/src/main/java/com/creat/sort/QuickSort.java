package com.creat.sort;

import org.junit.Test;

/**
 * Created by whz on 2017/8/23.
 */
public class QuickSort {

    @Test
    public void testSort(){
        Integer[] array = new Integer[]{10,54,78,789,30,310,354,365,312,412,564,474,499,574,400,55,47,123,156,126,50,100,20,41,414,33,454,1000,40,70};
        sort(array);
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    public static <T extends Comparable<? super T>> void sort(T[] array){
        sort(array,0, array.length-1);
    }

    public static <T extends Comparable<? super T>> void insertSort(T[] array,int left, int right){
        int length = array.length;
        T temp = null;
        for(int i = 1+left; i <= right; i++){
            for(int n = i-1; n >= left; n--){
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

    private static <T extends Comparable<? super T>> void sort(T[] array,int left, int right){
        if(right - left +1 > 20){
            T pivot = getPivot(array, left, right);
            int l = left;
            int r = right - 2;
            while(l < r){
                while(array[l].compareTo(pivot) < 0){
                    l++;
                }
                while(array[r].compareTo(pivot) > 0 ){
                    r--;
                }
                if(l < r){
                    swap(array, l, r);
                }else {
                    break;
                }
            }
            swap(array, l, right - 1);
            sort(array, left, l-1);
            sort(array, l+1, right);
        }else {
            insertSort(array, left, right);
        }
    }

    private static <T extends Comparable<? super T>> T getPivot(T[] array,int left, int right){
        int middle = (left + right)/2;
        if(array[left].compareTo(array[middle]) > 0){
            swap(array, left, middle);
        }
        if(array[left].compareTo(array[right]) > 0 ){
            swap(array, left, right);
        }
        if(array[middle].compareTo(array[right]) > 0){
            swap(array, middle, right);
        }
        swap(array, middle, right-1);
        return array[right-1];
    }

    private static <T extends Comparable<? super T>> void swap(T[] array,int one, int anthor){
        T temp = array[one];
        array[one] = array[anthor];
        array[anthor] = temp;
    }
}
