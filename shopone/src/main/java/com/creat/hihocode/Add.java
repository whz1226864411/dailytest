package com.creat.hihocode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/10/28.
 */
public class Add {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        List<Integer> results = new ArrayList<Integer>();
        while (scanner.hasNext()){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            results.add(a+b);
        }
        scanner.close();
        for(int i : results){
            System.out.println(i);
        }

    }
}
