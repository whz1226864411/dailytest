package com.creat.binarytree;

/**
 * Created by WHZ on 2017/8/11 0011.
 */
public class BinarySearchTree<E extends Comparable<? super E>>{

    private BinaryNode<E> root;

    private static class BinaryNode<E>{
        E element;
        BinaryNode<E> left;
        BinaryNode<E>  right;

        BinaryNode(E element){
            this.element = element;
            this.left = null;
            this.right = null;
        }

        BinaryNode(BinaryNode<E> left, E element, BinaryNode<E> right){
            this.left = left;
            this.element = element;
            this.right = right;
        }
    }

    public BinarySearchTree(){
        root = null;
    }

    public void makeEmpty(){
        root = null;
    }

    public boolean isEmpty(){
        return (root == null);
    }

    public boolean contains(E x){
        return contains(x,root);
    }

    private boolean contains(E x,BinaryNode<E> node){
        if(node == null){
            return false;
        }
        final int result = node.element.compareTo(x);
        if(result > 0){
            return contains(x, node.left);
        }else if( result < 0){
            return contains(x, node.right);
        }else {
            return true;
        }
    }

    public void insert(E x){
        root = insert(x , root);
    }

    private BinaryNode<E> insert(E x, BinaryNode<E> node){
        if(node == null){
            return new BinaryNode<E>(x);
        }
        int result = node.element.compareTo(x);
        if(result > 0){
            node.left = insert(x, node.left);
        }else if(result < 0){
            node.right = insert(x, node.right);
        }else {
            ;
        }
        return node;
    }

    public void remove(E x){
        root = remove(x, root);
    }

    private BinaryNode<E>  remove(E x, BinaryNode<E> node){
        if(node == null){
            return null;
        }
        final int result = node.element.compareTo(x);
        if(result > 0){
            node.left = remove(x , node.left);
        }else if( result < 0){
            node.right = remove(x, node.right);
        }else if(node.left != null && node.right != null){
            node.element = findMin(node.right).element;
            node.right = remove(node.element, node.right);
        }else {
            node = (node.right != null) ? node.right: node.left;
        }
        return node;
    }

    private BinaryNode<E> findMax(BinaryNode<E> node){
        if(node != null){
            while(node.right != null){
                node = node.right;
            }
        }
        return node;
    }

    private BinaryNode<E> findMin(BinaryNode<E> node){
        if(node != null){
            while(node.left != null){
                node = node.left;
            }
        }
        return node;
    }
    public void printTree(){
        printTree(root);
    }

    private void printTree(BinaryNode<E> node){
        if(node != null) {
            printTree(node.left);
            System.out.println(node.element);
            printTree(node.right);
        }
    }
}
