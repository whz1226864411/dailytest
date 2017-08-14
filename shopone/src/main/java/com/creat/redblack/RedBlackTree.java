package com.creat.redblack;


/**
 * Created by WHZ on 2017/8/13 0013.
 */
public class RedBlackTree<E extends Comparable<? super E>>{
    private RedBlackNode<E> root;

    private static class RedBlackNode<E>{
        int color;
        E element;
        RedBlackNode<E> left;
        RedBlackNode<E> right;
        RedBlackNode<E> father;

        static final int BLACK = 1;
        static final int RED =  0;

        RedBlackNode(E element){
            this.element = element;
            this.father = null;
            this.left = null;
            this.right = null;
            this.color = RedBlackNode.RED;
        }

        RedBlackNode(E element, RedBlackNode<E> father){
            this.element = element;
            this.father = father;
            this.left = null;
            this.right = null;
            this.color = RedBlackNode.RED;
        }
        RedBlackNode(E element,RedBlackNode<E> father,int color){
            this.element = element;
            this.father = father;
            this.left = null;
            this.right = null;
            this.color = color;
        }
    }

    public void printTree(){
        printTree(root);
    }

    private void printTree(RedBlackNode<E> node){
        if(node != null){
            printTree(node.left);
            System.out.println(node.element+((node.color==1)?"黑色":"红色"));
            printTree(node.right);
        }
    }

    public void insert(E element){
        if(root == null){
            root = new RedBlackNode<E>(element,null,RedBlackNode.BLACK);
        }else {
            RedBlackNode<E> point = root;
            int compareResult = element.compareTo(point.element);
            while(compareResult != 0){
                if(isRed(point.left) && isRed(point.right)){
                    if(point == root){
                        point.left.color = RedBlackNode.BLACK;
                        point.right.color = RedBlackNode.BLACK;
                    }else {
                        point.color = RedBlackNode.RED;
                        point.left.color = RedBlackNode.BLACK;
                        point.right.color = RedBlackNode.BLACK;
                        if(point.father.color == RedBlackNode.RED){
                            rotate(point);
                        }
                    }
                }
                if(compareResult > 0 ){
                   if(point.right == null){
                       point.right = new RedBlackNode<E>(element,point);
                       if(point.color == RedBlackNode.RED){
                            rotate(point.right);
                       }
                       break;
                   }else {
                       point = point.right;
                       compareResult = element.compareTo(point.element);
                   }
                }else if (compareResult < 0){
                    if(point.left == null){
                        point.left = new RedBlackNode<E>(element,point);
                        if(point.color == RedBlackNode.RED){
                            rotate(point.left);
                        }
                        break;
                    }else {
                        point = point.left;
                        compareResult = element.compareTo(point.element);
                    }
                }else {
                    break;
                }

            }
        }
    }

    private void rotate(RedBlackNode<E> point) {
        RedBlackNode<E> father = point.father;
        RedBlackNode<E> grandfather = father.father;
        RedBlackNode<E> result = null;
        if(isLeftNode(father) && isLeftNode(point)){
            result = rotateWithLeftChild(grandfather);
        }else if(isRightNode(father) && isRightNode(point)){
            result = rotateWithRightChild(grandfather);
        }else if(isLeftNode(father) && isRightNode(point)){
            result = doubleWithLeftChild(grandfather);
        }else {
            result = doubleWithRightChild(grandfather);
        }
        if(grandfather == root){
            root = result;
        }else {
            if(isRightNode(result)){
                result.father.right = result;
            }else {
                result.father.left = result;
            }
        }
    }

    private RedBlackNode<E> rotateWithLeftChild(RedBlackNode<E> node){
        RedBlackNode<E> left = node.left;
        node.left = left.right;
        left.right = node;
        node.color = RedBlackNode.RED;
        left.color = RedBlackNode.BLACK;
        left.father = node.father;
        node.father = left;
        if(node.left != null){
            node.left.father = node;
        }
        return left;
    }

    private RedBlackNode<E> rotateWithRightChild(RedBlackNode<E> node){
        RedBlackNode<E> right = node.right;
        node.right = right.left;
        right.left = node;
        node.color = RedBlackNode.RED;
        right.color = RedBlackNode.BLACK;
        right.father = node.father;
        node.father = right;
        if(node.right != null){
            node.right.father = node;
        }
        return right;
    }

    private RedBlackNode<E> doubleWithLeftChild(RedBlackNode<E> node){
        node.left = rotateWithRightChild(node.left);
        return rotateWithLeftChild(node);
    }

    private RedBlackNode<E> doubleWithRightChild(RedBlackNode<E> node){
        node.right = rotateWithLeftChild(node.right);
        return rotateWithRightChild(node );
    }

    private boolean isRed(RedBlackNode<E> node){
        if(node == null){
            return false;
        }else if(node.color == RedBlackNode.RED){
            return true;
        }else {
            return false;
        }
    }
    private boolean isBlack(RedBlackNode<E> node){
        if(node == null){
            return true;
        }else if(node.color == RedBlackNode.BLACK){
            return true;
        }else {
            return false;
        }
    }
    private boolean isLeftNode(RedBlackNode<E> node){
        RedBlackNode<E> father = node.father;
        if(father == null){
            return false;
        }else {
            int compareResult = node.element.compareTo(father.element);
            if(compareResult < 0){
                return true;
            }else {
                return false;
            }
        }
    }
    private boolean isRightNode(RedBlackNode<E> node){
        RedBlackNode<E> father = node.father;
        if(father == null){
            return false;
        }else {
            int compareResult = node.element.compareTo(father.element);
            if(compareResult > 0){
                return true;
            }else {
                return false;
            }
        }
    }
}
