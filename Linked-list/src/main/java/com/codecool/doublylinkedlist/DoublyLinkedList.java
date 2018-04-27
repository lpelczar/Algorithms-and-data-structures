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
                if (current.getNext() != null) {
                    current.getNext().setPrevious(insertedNode);
                }
                current.setNext(insertedNode);
                insertedNode.setPrevious(current);
                if (index == size) {
                    tail = insertedNode;
                }
                size++;
            }
            counter++;
            current = current.getNext();
        }
    }

    public boolean delete(T data) {
        if (head == null) {
            return false;
        }

        boolean isDeleted = false;
        if (head.getData().equals(data)) {
            this.head = head.getNext();
            size--;
            isDeleted = true;
        } else {
            Node<T> current = head;
            while (current.getNext() != null) {
                if (current.getNext().getData().equals(data)) {
                    Node<T> removedNode = current.getNext();
                    if (removedNode.getNext() != null) {
                        current.setNext(removedNode.getNext());
                        removedNode.getNext().setPrevious(current);
                    } else {
                        current.setNext(null);
                        tail = current;
                    }
                    size--;
                    isDeleted = true;
                    break;
                }
                current = current.getNext();
            }
        }
        return isDeleted;
    }

    public T getByIndex(int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if (head == null) {
            throw new ArrayIndexOutOfBoundsException("Empty list");
        }
        T data = null;
        if (index == 0) {
            data = head.getData();
        }

        int counter = 0;
        Node<T> current = head;
        while (current != null) {
            if (counter == index) {
                data = current.getData();
            }
            counter++;
            current = current.getNext();
        }
        return data;
    }

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
