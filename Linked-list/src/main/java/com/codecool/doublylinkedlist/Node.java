package com.codecool.doublylinkedlist;

class Node<T> {

    private T data;
    private Node<T> next;
    private Node<T> previous;

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
        appended.previous = current;
        return appended;
    }

    T getData() {
        return data;
    }

    Node<T> getNext() {
        return next;
    }

    void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }
}
