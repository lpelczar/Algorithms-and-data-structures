package com.codecool.dynamicArrayDojo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BasicDynamicIntArrayTest {

    @Test
    void whenAddThenElementIsAdded() {
        BasicDynamicIntArray dynamicArray = new BasicDynamicIntArray();
        dynamicArray.add(8);
        String expected = " 8";
        assertEquals(expected, dynamicArray.toString());
    }

    @Test
    void whenAddMultipleTimesThenElementsAreCorrectlyAdded() {
        BasicDynamicIntArray dynamicArray = new BasicDynamicIntArray();
        dynamicArray.add(8);
        dynamicArray.add(10);
        dynamicArray.add(3);
        String expected = " 8 10 3";
        assertEquals(expected, dynamicArray.toString());
    }

    @Test
    void whenGetThenCorrectElementIsReturned() {
        BasicDynamicIntArray dynamicArray = new BasicDynamicIntArray();
        dynamicArray.add(8);
        dynamicArray.add(10);
        dynamicArray.add(3);
        assertEquals(3, dynamicArray.get(2));
    }

    @Test
    void whenGetWithIndexGreaterThanSizeThenThrowException() {
        BasicDynamicIntArray dynamicArray = new BasicDynamicIntArray();
        dynamicArray.add(8);
        assertThrows(IndexOutOfBoundsException.class, () -> dynamicArray.get(2));
    }

    @Test
    void whenGetWithIndexLowerThan0ThenThrowException() {
        BasicDynamicIntArray dynamicArray = new BasicDynamicIntArray();
        dynamicArray.add(8);
        assertThrows(IndexOutOfBoundsException.class, () -> dynamicArray.get(-1));
    }

    @Test
    void whenInsertAtTheBeginningThenElementIsProperlyInserted() {
        BasicDynamicIntArray dynamicArray = new BasicDynamicIntArray();
        dynamicArray.add(8);
        dynamicArray.add(10);
        dynamicArray.insert(0, 11);
        String expected = " 11 8 10";
        assertEquals(expected, dynamicArray.toString());
    }

    @Test
    void whenInsertInTheMiddleThenElementIsProperlyInserted() {
        BasicDynamicIntArray dynamicArray = new BasicDynamicIntArray();
        dynamicArray.add(8);
        dynamicArray.add(10);
        dynamicArray.add(15);
        dynamicArray.add(18);
        dynamicArray.insert(2, 11);
        String expected = " 8 10 11 15 18";
        assertEquals(expected, dynamicArray.toString());
    }

    @Test
    void whenInsertAtTheEndThenElementIsProperlyInserted() {
        BasicDynamicIntArray dynamicArray = new BasicDynamicIntArray();
        dynamicArray.add(8);
        dynamicArray.add(10);
        dynamicArray.add(15);
        dynamicArray.insert(3, 11);
        String expected = " 8 10 15 11";
        assertEquals(expected, dynamicArray.toString());
    }

    @Test
    void whenInsertAndIndexGreaterThanSizeThenThrowException() {
        BasicDynamicIntArray dynamicArray = new BasicDynamicIntArray();
        dynamicArray.add(8);
        dynamicArray.add(10);
        assertThrows(IndexOutOfBoundsException.class, () -> dynamicArray.insert(3, 8));
    }

    @Test
    void whenInsertAndIndexLowerThan0ThenThrowException() {
        BasicDynamicIntArray dynamicArray = new BasicDynamicIntArray();
        dynamicArray.add(8);
        dynamicArray.add(10);
        assertThrows(IndexOutOfBoundsException.class, () -> dynamicArray.insert(-1, 8));
    }

    @Test
    void whenMaxThenReturnMaxElement() {
        BasicDynamicIntArray dynamicArray = new BasicDynamicIntArray();
        dynamicArray.add(8);
        dynamicArray.add(100);
        dynamicArray.add(10);
        assertEquals(100, dynamicArray.max());
    }
}
