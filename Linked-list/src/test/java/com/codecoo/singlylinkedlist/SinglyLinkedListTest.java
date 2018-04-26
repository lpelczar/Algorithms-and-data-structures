package com.codecoo.singlylinkedlist;

import com.codecool.singlylinkedlist.SinglyLinkedList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


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
    public void whenGetLatThenReturnLast() {
        SinglyLinkedList<Integer> linkedList = createList(11);
        assertEquals(new Integer(10), linkedList.getLast());
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
