package com.codecool.singlylinkedlist;

public class SinglyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public SinglyLinkedList() {}

    public SinglyLinkedList(T data) {
        this.head = new Node<>(data);
    }

    public T getFirst() {
        return head.getData();
    }

    public T getTail() {
        return tail.getData();
    }

    public int size() {
        return size;
    }

    public void add(T data) {
        if (head == null) {
            this.head = new Node<>(data);
        } else {
            tail = head.append(data);
        }
        size++;
    }

    public void addAsFirst(T data) {
        Node<T> newHead = new Node<>(data);
        newHead.setNext(this.head);
        this.head = newHead;
        size++;
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node<T> current = head;
        while (current != null) {
            stringBuilder.append(" ");
            stringBuilder.append(current.getData());
            current = current.getNext();
        }
        return stringBuilder.toString();
    }
}
