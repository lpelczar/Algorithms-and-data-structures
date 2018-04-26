package com.codecool.singlylinkedlist;

public class Node<T> {

    private T data;
    private Node<T> next;

    public Node(T data) {
        this.data = data;
    }

    public void append(T data) {
        Node<T> current = this;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node<>(data);
    }

    public T getData() {
        return data;
    }
}