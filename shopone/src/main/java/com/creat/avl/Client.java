package com.creat.avl;

/**
 * Created by whz on 2017/8/12 0012.
 */
public class Client {

    public static void main(String[] args){
        AvlTree<Integer> avlTree = new AvlTree<Integer>();
        avlTree.insert(5);
        avlTree.insert(50);
        avlTree.insert(5000);
        avlTree.insert(500);
        avlTree.insert(1);
        avlTree.printTree();
    }
}
