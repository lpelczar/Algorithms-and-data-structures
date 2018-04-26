package com.codecool.singlylinkedlist;

class Node<T> {

    private T data;
    private Node<T> next;

    Node(T data) {
        this.data = data;
    }

    Node<T> append(T data) {
        Node<T> current = this;
        while (current.next != null) {
            current = current.next;
        }
        Node<T> appended = new Node<>(data);
        current.next = appended;
        return appended;
    }

    T getData() {
        return data;
    }

    Node<T> getNext() {
        return next;
    }
}