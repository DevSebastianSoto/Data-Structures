package com.devssm;

public class Node<E> {
    private E elem;
    private Node<E> next, previous;

    public Node(E elem) {
        this.elem = elem;
    }

    public E getElem() {
        return elem;
    }

    public void setElem(E elem) {
        this.elem = elem;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<E> previous) {
        this.previous = previous;
    }
}
