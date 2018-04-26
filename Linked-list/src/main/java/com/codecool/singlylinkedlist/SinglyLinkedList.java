package com.codecool.singlylinkedlist;

public class SinglyLinkedList<T> {

    private Node<T> head;
    private Node<T> last = null;
    private int length = 0;

    public SinglyLinkedList(Node<T> head) {
        this.head = head;
    }

    public Node getFirst() {
        return head;
    }
}
