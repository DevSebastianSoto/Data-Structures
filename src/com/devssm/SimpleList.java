package com.devssm;

import java.lang.reflect.Array;

public class SimpleList<E extends Object> {
    private Node<E> head;
    private int size;

    private void removeNode(Node<E> tmp) {
        if (tmp.equals(this.head)) {
            this.head = this.head.getNext();
            this.head.setPrevious(null);
        } else {
            tmp.getPrevious().setNext(tmp.getNext());
            if (tmp.getNext() != null) {
                tmp.getNext().setPrevious(tmp.getPrevious());
            }
        }
        tmp = null;
        this.size--;
        System.gc();
    }
    private Node<E> getNodeByElement(E elem) throws IllegalArgumentException {

        Node<E> tmp = this.head;
        int i = 0;
        while (tmp != null && !tmp.getElem().equals(elem)) {
            tmp = tmp.getNext();
            i++;
        }
        if (tmp != null) {
            return tmp;
        } else {
            throw new IllegalArgumentException("The searched value does not exist.");
        }
    }
    private Node<E> getNodeByIndex(int index) throws IndexOutOfBoundsException {

        Node<E> tmp = this.head;
        int i = 0;
        while (i != index && tmp != null) {
            tmp = tmp.getNext();
            i++;
        }
        if (tmp != null) {
            return tmp;
        } else
            throw new IndexOutOfBoundsException("Index:\t" + index + "\tIs out of bounds.");
    }

    public SimpleList() {
        this.head = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size <= 0;
    }

    public void add(E elem) {
        Node<E> tmp = new Node<>(elem);
        if (isEmpty()) {
            this.head = tmp;
            this.size++;
        } else {
            Node<E> marker = this.head;
            while (marker.getNext() != null) {
                marker = marker.getNext();
            }
            marker.setNext(tmp);
            tmp.setPrevious(marker);
            this.size++;
        }
    }

    public E get(int index) {
        return getNodeByIndex(index).getElem();
    }

    public boolean set(int index, E elem) {
        try {
            if(elem != null){
                getNodeByIndex(index).setElem(elem);
                return true;
            }
            return false;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public boolean remove(int index) {
        try {
            Node<E> tmp = getNodeByIndex(index);
            removeNode(tmp);
            return true;
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean remove(E elem) {
        try {
            Node<E> tmp = getNodeByElement(elem);
            removeNode(tmp);
            return true;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }

    public E [] toArray(Class<E[]> cls){
        E[] arr = cls.cast(Array.newInstance(cls.getComponentType(), this.size));
        Node<E> tmp = this.head;
        int i = 0;
        while (i < this.size && tmp != null) {
            arr[i] = tmp.getElem();
            tmp = tmp.getNext();
            i++;
        }
        return arr;
    }
}
