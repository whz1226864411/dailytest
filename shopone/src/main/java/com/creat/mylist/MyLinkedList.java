package com.creat.mylist;

/**
 * Created by WHZ on 2017/8/10 0010.
 */
public class MyLinkedList<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    private class Node<E>{
        Node<E> prev;
        E item;
        Node<E> next;

        Node(Node<E> prev, E item, Node<E> next){
            this.item = item;
            this.prev = prev;
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
        if(first != null){
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
        }
        return false;
    }


    public boolean add(E e) {
        Node<E> newNode = new Node<E>(last, e, null);
        if(last == null){
            first = newNode;
        }else {
            last.next = newNode;
        }
        last = newNode;
        size++;
        return false;
    }

    public boolean remove(Object o) {
        if(first != null){
            if(o == null){
                for(Node<E> x = first; x != null; x = x.next){
                    if(x.item == null){
                        if(x == first){
                            x.next.prev = null;
                            first = x.next;
                        }else if(x == last){
                            x.prev.next = null;
                            last = x.prev;
                        }else {
                            x.next.prev = x.prev;
                            x.prev.next = x.next;
                        }
                        size--;
                        return true;
                    }
                }
            }else {
                for(Node<E> x = first; x != null; x = x.next){
                    if(o.equals(x.item)){
                        if(x == first){
                            x.next.prev = null;
                            first = x.next;
                        }else if(x == last){
                            x.prev.next = null;
                            last = x.prev;
                        }else {
                            x.next.prev = x.prev;
                            x.prev.next = x.next;
                        }
                        size--;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    public E get(int index) {
        if(first != null && size > index && index >= 0){
            if(size/2 > index){
                Node<E> temp = first;
                for(int i = 0; i < index; i++){
                    temp = temp.next;
                }
                return temp.item;
            }else {
                Node<E> temp = last;
                for(int i = size-index; i > 1; i--){
                    temp = temp.prev;
                }
                return temp.item;
            }
        }else{
            throw new IndexOutOfBoundsException("越界");
        }
    }

    public E set(int index, E element) {
        if(first != null && size > index && index >= 0){
            if(size/2 > index){
                Node<E> temp = first;
                for(int i = 0; i < index; i++){
                    temp = temp.next;
                }
                temp.item = element;
                return temp.item;
            }else {
                Node<E> temp = last;
                for(int i = size-index; i > 1; i--){
                    temp = temp.prev;
                }
                temp.item = element;
                return temp.item;
            }
        }else{
            throw new IndexOutOfBoundsException("越界");
        }
    }

    public void add(int index, E element) {
        if(first != null && size > index && index >= 0){
            if(size/2 > index){
                Node<E> x = first;
                for(int i = 0; i < index; i++){
                    x = x.next;
                }
                Node<E> newNode = new Node<E>(x.prev, element, x);
                if(x == first){
                    x.prev = newNode;
                   first = newNode;
                }else {
                    x.prev.next = newNode;
                    x.prev = newNode;
                }
            }else {
                Node<E> x = last;
                for(int i = size-index; i > 1; i--){
                    x = x.prev;
                }
                Node<E> newNode = new Node<E>(x.prev, element, x);
                if(x == first){
                    x.prev = newNode;
                    first = newNode;
                }else {
                    x.prev.next = newNode;
                    x.prev = newNode;
                }
            }
            size++;
        }else{
            throw new IndexOutOfBoundsException("越界");
        }
    }

    public int indexOf(Object o) {
        int index = 0;
        for(Node<E> x = first; x != null; x = x.next){
            if(o == null){
                if(x.item == null){
                    return index;
                }
            }else {
                if(o.equals(x.item)){
                    return index;
                }
            }
            index++;
        }
        return -1;
    }


}
