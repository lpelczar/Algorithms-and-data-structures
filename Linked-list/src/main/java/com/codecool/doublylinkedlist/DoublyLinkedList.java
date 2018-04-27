package com.codecool.doublylinkedlist;


public class DoublyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public DoublyLinkedList() {}

    public DoublyLinkedList(T data) {
        head = new Node<>(data);
    }

    public T getFirst() {
        if (head == null) {
            throw new ArrayIndexOutOfBoundsException("Empty list");
        }
        return head.getData();
    }

    public T getLast() {
        if (tail == null) {
            throw new ArrayIndexOutOfBoundsException("Empty list");
        }
        return tail.getData();
    }

    public int size() {
        return size;
    }

    public void add(T data) {
        if (head == null) {
            head = new Node<>(data);
        } else {
            tail = head.append(data);
        }
        size++;
    }

    public void addAsFirst(T data) {
        Node<T> newHead = new Node<>(data);
        if (head != null) {
            newHead.setNext(head);
            head.setPrevious(newHead);
        }
        head = newHead;
        size++;
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
