package com.codecool.singlylinkedlist;

public class SinglyLinkedList<T> {

    private Node<T> head;
    private Node<T> last = null;
    private int length = 0;

    public SinglyLinkedList(T data) {
        this.head = new Node<>(data);
    }

    public T getFirst() {
        return head.getData();
    }

    public void append(T data) {

    }
}
