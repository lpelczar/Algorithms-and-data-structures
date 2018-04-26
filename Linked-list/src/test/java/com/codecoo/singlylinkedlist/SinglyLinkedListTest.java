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

    private SinglyLinkedList<Integer> createList(int numOfElements) {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        for (Integer i = 0; i < numOfElements; ++i)
        {
            linkedList.add(i);
        }
        return linkedList;
    }
}
