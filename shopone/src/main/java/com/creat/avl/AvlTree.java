package com.creat.avl;

/**
 * Created by whz on 2017/8/12 0012.
 */
public class AvlTree<E extends Comparable<? super E>> {

    private AvlNode<E> root;
    private class AvlNode<E>{
        E element;
        AvlNode<E> left;
        AvlNode<E> right;
        int height;

        AvlNode(E element){
            this.element = element;
            this.right = null;
            this.left = null;
            this.height = 0;
        }

        AvlNode(E element, AvlNode<E> left, AvlNode<E> right){
            this.element = element;
            this.right = right;
            this.left = left;
            this.height = 0;
        }

    }

    public void insert(E element){
        root = insert(element,root);
    }

    private AvlNode<E> insert(E element, AvlNode<E> node){
        if(node == null){
            return new AvlNode<E>(element);
        }
        int compareResult = element.compareTo(node.element);
        if(compareResult > 0){
            node.right = insert(element,node.right);
            if(getHeight(node.right) - getHeight(node.left) == 2){
                if(element.compareTo(node.right.element) > 0){
                    node = rotateWithRightChild(node);
                }else {
                    node = doubleWithRightChild(node);
                }
            }
        }else if( compareResult < 0 ){
            node.left = insert(element,node.left);
            if(getHeight(node.left) - getHeight(node.right) == 2){
                if(element.compareTo(node.left.element) < 0){
                    node = rotateWithLeftChild(node);
                }else {
                    node = doubleWithLeftChild(node);
                }
            }
        }else {
            ;
        }
        node.height = Math.max(getHeight(node.right),getHeight(node.left))+1;
        return node;
    }

    private int getHeight(AvlNode<E> node){
        return (node == null) ? -1 : node.height;
    }

    private AvlNode<E> rotateWithLeftChild(AvlNode<E> node){
        AvlNode<E> l = node.left;
        node.left = l.right;
        l.right = node;
        node.height = Math.max(getHeight(node.left),getHeight(node.right))+1;
        l.height = Math.max(getHeight(l.left),node.height)+1;
        return l;
    }

    private AvlNode<E> rotateWithRightChild(AvlNode<E> node){
        AvlNode<E> r = node.right;
        node.right = r.left;
        r.left = node;
        node.height = Math.max(getHeight(node.right),getHeight(node.left))+1;
        r.height = Math.max(getHeight(r.right),node.height)+1;
        return r;
    }

    private AvlNode<E> doubleWithLeftChild(AvlNode<E> node){
        node.left = rotateWithRightChild(node.left);
        return rotateWithLeftChild(node);
    }

    private AvlNode<E> doubleWithRightChild(AvlNode<E> node){
        node.right = rotateWithLeftChild(node.right);
        return rotateWithRightChild(node);
    }

    public void printTree(){
        printTree(root);
    }

    private void printTree(AvlNode<E> node){
        if(node != null){
            printTree(node.left);
            System.out.println(node.element+":height=:"+getHeight(node));
            printTree(node.right);
        }
    }
}
