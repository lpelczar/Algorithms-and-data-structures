package com.codecool.singlylinkedlist;

public class SinglyLinkedList<T> {

    private Node<T> head;
    private Node<T> last;
    private int length;

    public SinglyLinkedList() {}

    public SinglyLinkedList(T data) {
        this.head = new Node<>(data);
    }

    public T getFirst() {
        return head.getData();
    }

    public T getLast() {
        return last.getData();
    }

    public void add(T data) {
        if (head == null) {
            this.head = new Node<>(data);
        } else {
            last = head.append(data);
        }
        length++;
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
