package com.creat.mylist;


/**
 * Created by WHZ on 2017/8/10 0010.
 */
public class MySingleList<E>{

    private Node<E> first;
    private int size;

    private class Node<E>{
        E item;
        Node<E> next;

        Node(E item,Node<E> next){
            this.item = item;
            this.next = next;
        }
    }
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public boolean contains(Object o) {
        if(o == null){
            for(Node<E> x = first; x != null; x = x.next){
                if(x.item == null){
                    return true;
                }
            }
        }else {
            for(Node<E> x = first; x != null; x = x.next){
                if(o.equals(x.item)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean add(E e) {
        Node<E> node = new Node<E>(e,null);
        if(first == null){
            first = node;
        }else {
            Node<E> x = null;
            for(x = first; x.next != null; x = x.next)
                ;
            x.next = node;
        }
        size++;
        return true;
    }

    public boolean remove(Object o) {
        if(first != null){
            if( o == null){
                Node<E> temp = null;
                for(Node<E> x = first; x != null; x = x.next){
                    if(x.item == null){
                        return removeNode(x, temp);
                    }
                    temp = x;
                }
            }else {
                Node<E> temp = null;
                for(Node<E> x = first; x != null; x = x.next){
                    if(o.equals(x.item)){
                        return removeNode(x, temp);
                    }
                    temp = x;
                }
            }
        }
        return false;
    }

    private boolean removeNode(Node<E> x, Node<E> temp){
        if(x == first){
            first = x.next;
            size--;
            return true;
        }else {
            temp.next = x.next;
            size--;
            return true;
        }
    }

    public void clear() {
        first = null;
        size = 0;
    }

    public E get(int index) {
        if(first != null && size > index && index >= 0){
             Node<E> x = first;
             for(int i = 0; i < index; i++){
                 x = x.next;
             }
             return x.item;
        }else {
            throw new IndexOutOfBoundsException("越界");
        }
    }

    public E set(int index, E element) {
        if(first != null && size > index && index >= 0 ){
            Node<E> x = first;
            for(int i = 0; i < index; i++){
                x = x.next;
            }
            x.item = element;
            return x.item;
        }else {
            throw new IndexOutOfBoundsException("越界");
        }
    }

    public void add(int index, E element) {
        if(first != null && size > index ){
            Node<E> x = first;
            Node<E> temp = null;
            for(int i = 0; i < index; i++){
                temp = x;
                x = x.next;
            }
            Node<E> newNode = new Node<E>(element,x);
            temp.next = newNode;
            size++;
        }else if(first == null && index == 0){
            first = new Node<E>(element,null);
            size++;
        }else {
            throw new IndexOutOfBoundsException("越界");
        }
    }


    public int indexOf(Object o) {
        if(first != null){
            if( o == null){
                int index = 0;
                for(Node<E> x = first; x != null; x = x.next){
                    if(x.item == null){
                        return index;
                    }
                    index++;
                }
            }else {
                int index = 0;
                for(Node<E> x = first; x != null; x = x.next){
                    if(o.equals(x.item)){
                        return index;
                    }
                    index++;
                }
            }
        }
        return -1;
    }

}
