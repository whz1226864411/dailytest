package com.creat.mylist;

/**
 * Created by WHZ on 2017/8/10 0010.
 */
public class MyLinkedClient {

    public static void main(String[] args){
        MyLinkedList<String> linkedList = new MyLinkedList<String>();
        linkedList.add("whz");
        linkedList.add("zdd");
        linkedList.add("haiyoushui");
        for(int i = 0; i < linkedList.size(); i++){
            System.out.println("第"+i+"个是："+linkedList.get(i));
        }
        System.out.println(linkedList.size());
        linkedList.add(1,"没谁了");
        for(int i = 0; i < linkedList.size(); i++){
            System.out.println("第"+i+"个是："+linkedList.get(i));
        }
        System.out.println("没谁了存在不："+linkedList.contains("没谁了"));
        System.out.println("没谁存在不："+linkedList.contains("没谁"));
        System.out.println("zdd在第几个："+linkedList.indexOf("zdd"));
        linkedList.remove("whz");
        linkedList.remove("haiyoushui");
        for(int i = 0; i < linkedList.size(); i++){
            System.out.println("第"+i+"个是："+linkedList.get(i));
        }
        linkedList.set(0,"whz");
        for(int i = 0; i < linkedList.size(); i++){
            System.out.println("第"+i+"个是："+linkedList.get(i));
        }
        linkedList.clear();
        System.out.println("是否为空："+linkedList.isEmpty());
        for(int i = 0; i < linkedList.size(); i++){
            System.out.println("第"+i+"个是："+linkedList.get(i));
        }
    }
}
