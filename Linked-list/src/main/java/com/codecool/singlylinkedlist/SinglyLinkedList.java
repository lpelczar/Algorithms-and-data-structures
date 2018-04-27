package com.codecool.singlylinkedlist;

public class SinglyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public SinglyLinkedList() {}

    public SinglyLinkedList(T data) {
        head = new Node<>(data);
    }

    public T getFirst() {
        return head.getData();
    }

    public T getLast() {
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
        newHead.setNext(head);
        head = newHead;
        size++;
    }

    public void insert(int index, T data) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if (index == 0) {
            addAsFirst(data);
        }

        int counter = 0;
        Node<T> current = head;
        while (current != null) {
            if (counter == index - 1) {
                Node<T> insertedNode = new Node<>(data);
                insertedNode.setNext(current.getNext());
                current.setNext(insertedNode);

                if (index == size) {
                    tail = insertedNode;
                }
                size++;
            }
            counter++;
            current = current.getNext();
        }
    }

//    public boolean deleteWithValue(T data) {
//        if (head != null && head.getData().equals(data)) {
//            this.head = head.getNext();
//            size--;
//        } else {
//            Node<T> current = head;
//            while (current.getNext() != null) {
//                if (current.getNext().getData().equals(data)) {
//
//                    size--;
//                }
//                current = current.getNext();
//            }
//        }
//    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean contains(T data) {
        boolean isFound = false;
        Node<T> current = head;
        while (current != null) {
            if (current.getData().equals(data)) {
                isFound = true;
            }
            current = current.getNext();
        }
        return isFound;
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
