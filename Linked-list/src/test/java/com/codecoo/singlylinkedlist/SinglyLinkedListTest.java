package com.codecoo.singlylinkedlist;

import com.codecool.singlylinkedlist.SinglyLinkedList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class SinglyLinkedListTest {

    @Test
    public void whenInstantiatedThenHeadIsProperlyDefined() {
        Integer firstElement = 0;
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>(firstElement);
        assertEquals(firstElement, list.getFirst());
    }

    @Test
    public void whenAddMultipleTimesThenItemsAreProperlyAdded() {
        SinglyLinkedList<Integer> linkedList = createList(11);
        linkedList.add(32);
        linkedList.add(42);
        String result = " 0 1 2 3 4 5 6 7 8 9 10 32 42";
        assertEquals(result, linkedList.toString());
    }

    @Test
    public void whenGetLastThenReturnLast() {
        SinglyLinkedList<Integer> linkedList = createList(11);
        assertEquals(new Integer(10), linkedList.getTail());
    }

    @Test
    public void whenAddAsFirstThenChangeHead() {
        SinglyLinkedList<Integer> linkedList = createList(11);
        linkedList.addAsFirst(890);
        String result = " 890 0 1 2 3 4 5 6 7 8 9 10";
        assertEquals(result, linkedList.toString());
        assertEquals(new Integer(890), linkedList.getFirst());
    }

    @Test
    public void whenElementsAddedThenReturnAppropriateLength() {
        SinglyLinkedList<Integer> linkedList = createList(12);
        linkedList.add(800);
        assertEquals(13, linkedList.size());
    }

    @Test
    public void whenClearThenListIsEmpty() {
        SinglyLinkedList<Integer> linkedList = createList(12);
        linkedList.clear();
        assertEquals("", linkedList.toString());
    }

    @Test
    public void whenContainsCalledAndElementExistsThenReturnTrue() {
        SinglyLinkedList<Integer> linkedList = createList(12);
        assertTrue(linkedList.contains(10));
    }

    private SinglyLinkedList<Integer> createList(int numOfElements) {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        for (Integer i = 0; i < numOfElements; ++i)
        {
            linkedList.add(i);
        }
        return linkedList;
    }
}
