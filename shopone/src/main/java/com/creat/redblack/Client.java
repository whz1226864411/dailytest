package com.creat.redblack;

/**
 * Created by Administrator on 2017/8/13 0013.
 */
public class Client {

    public static void main(String[] args){
        RedBlackTree<Integer> tree = new RedBlackTree<Integer>();
        tree.insert(30);
        tree.insert(70);
        tree.insert(60);
        tree.insert(15);
        tree.insert(10);
        tree.insert(20);
        tree.insert(80);
        tree.insert(85);
        tree.insert(50);
        tree.insert(65);
        tree.insert(5);
        tree.insert(40);
        tree.insert(55);
        tree.insert(89);
        tree.insert(65);
        tree.printTree();
    }
}
