package com.creat.binarytree;

/**
 * Created by Administrator on 2017/8/11 0011.
 */
public class Client {

    public static void main(String[] args){
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(5);
        tree.insert(15);
        tree.insert(50);
        tree.insert(5000);
        tree.insert(500);
        System.out.println(tree.contains(50));
        tree.remove(50);
        System.out.println(tree.contains(50));
        tree.printTree();

    }
}
