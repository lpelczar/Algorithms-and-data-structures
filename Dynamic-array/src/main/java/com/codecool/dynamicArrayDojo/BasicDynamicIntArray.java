package com.codecool.dynamicArrayDojo;

public class BasicDynamicIntArray {

    private int max = 0;
    private int capacity = 5;
    private int size = 0;
    private int[] elements = new int[capacity];

    void add(int n) {
        ensureExtraCapacity();
        elements[size++] = n;
        checkMax(n);
    }

    int get(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        return elements[index];
    }

    void insert(int index, int n) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        ensureExtraCapacity();
        checkMax(n);
        int[] newElements = new int[++size];
        for (int i = 0; i < newElements.length; i++) {
            newElements[i] = elements[i];
            if (i == index) {
                newElements[i] = n;
                break;
            }
        }
        for (int i = index + 1; i < newElements.length; i++) {
            newElements[i] = elements[i - 1];
        }
        elements = newElements;
    }

    private void checkMax(int n) {
        if (n > max) {
            max = n;
        }
    }

    int max() {
        return max;
    }

    private void ensureExtraCapacity() {
        if (size - 1 == capacity) {
            capacity *= 2;
            int[] newElements = new int[capacity];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            this.elements = newElements;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(" ");
            stringBuilder.append(elements[i]);
        }
        return stringBuilder.toString();
    }
}
