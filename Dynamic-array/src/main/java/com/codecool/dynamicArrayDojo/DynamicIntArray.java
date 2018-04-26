package com.codecool.dynamicArrayDojo;

import java.util.Arrays;
import java.util.stream.IntStream;

class DynamicIntArray {

    private int[] array;
    private int size = 0;

    DynamicIntArray() {
        this.array = new int[0];
    }

    DynamicIntArray(int capacity) {
        this.array = new int[capacity];
    }

    void add(int number) {
        if (size < array.length) {
            array[size] = number;
            size++;
        } else {
            this.array = Arrays.copyOf(array, array.length + 1);
            array[size] = number;
            size++;
        }
    }

    void remove(int index) {
        if (index < 0 || index >= array.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int[] firstHalf = Arrays.copyOfRange(array, 0, index);
        int[] secondHalf = Arrays.copyOfRange(array, index + 1, array.length);
        this.array = IntStream.concat(Arrays.stream(firstHalf), Arrays.stream(secondHalf)).toArray();
        size--;
    }

    void insert(int index, int value) {
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else if (index >= array.length) {
            add(value);
        } else {
            int[] firstHalf = Arrays.copyOfRange(array, 0, index);
            int[] secondHalf = Arrays.copyOfRange(array, index, array.length);
            int[] firstWithValue = IntStream.concat(Arrays.stream(firstHalf), Arrays.stream(new int[]{value})).toArray();
            this.array = IntStream.concat(Arrays.stream(firstWithValue), Arrays.stream(secondHalf)).toArray();
            size++;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int number : array) {
            result.append(" ");
            result.append(number);
        }
        return result.toString();
    }
}
