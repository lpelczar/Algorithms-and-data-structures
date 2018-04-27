package com.codecool.doublylinkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DoublyLinkedListTest {

    @Test
    void whenInstantiatedThenHeadIsProperlyDefined() {
        Integer firstElement = 0;
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>(firstElement);
        assertEquals(firstElement, list.getFirst());
    }

    @Test
    void whenAddMultipleTimesThenItemsAreProperlyAdded() {
        DoublyLinkedList<Integer> linkedList = createList(11);
        linkedList.add(33);
        linkedList.add(45);
        String result = " 0 1 2 3 4 5 6 7 8 9 10 33 45";
        assertEquals(result, linkedList.toString());
    }

    @Test
    void whenGetLastThenReturnLast() {
        DoublyLinkedList<Integer> linkedList = createList(11);
        assertEquals(new Integer(10), linkedList.getLast());
    }

    @Test
    void whenAddAsFirstThenChangeHead() {
        DoublyLinkedList<Integer> linkedList = createList(11);
        linkedList.addAsFirst(800);
        String result = " 800 0 1 2 3 4 5 6 7 8 9 10";
        assertEquals(result, linkedList.toString());
        assertEquals(new Integer(800), linkedList.getFirst());
    }

    @Test
    void whenElementsAddedThenReturnAppropriateLength() {
        DoublyLinkedList<Integer> linkedList = createList(12);
        linkedList.add(800);
        assertEquals(13, linkedList.size());
    }

    private DoublyLinkedList<Integer> createList(int numOfElements) {
        DoublyLinkedList<Integer> linkedList = new DoublyLinkedList<>();
        for (Integer i = 0; i < numOfElements; ++i)
        {
            linkedList.add(i);
        }
        return linkedList;
    }
}
