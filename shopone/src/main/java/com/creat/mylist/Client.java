package com.creat.mylist;

import java.io.IOException;

/**
 * Created by Administrator on 2017/8/10 0010.
 */
public class Client {
    public static void main(String[] args ) throws IOException {
        MySingleList<Integer> list = new MySingleList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("是否包含3:"+list.contains(3));
        System.out.println("3的索引值:"+list.indexOf(3));
        System.out.println("索引1上的数："+list.get(1));
        list.add(1,4);
        for(int i = 0; i < list.size(); i++){
            System.out.print("第"+i+"个数："+list.get(i)+" ;");
        }
        System.out.println();
        list.set(1,6);
        for(int i = 0; i < list.size(); i++){
            System.out.print("第"+i+"个数："+list.get(i)+" ;");
        }
        System.out.println();
        System.out.println("是否为空："+list.isEmpty());
        System.out.println("链表大小："+list.size());
        list.clear();
        System.out.println("是否为空："+list.isEmpty());
        System.out.println("链表大小："+list.size());
        for(int i = 0; i < list.size(); i++){
            System.out.print("第"+i+"个数："+list.get(i)+" ;");
        }
    }
}
