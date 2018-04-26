package com.codecoo.singlylinkedlist;

import com.codecool.singlylinkedlist.SinglyLinkedList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class SinglyLinkedListTest {

    @Test
    public void whenInstantiatedThenHeadIsProperlyDefined() {
        String firstElement = "Element1";
        SinglyLinkedList<String> list = new SinglyLinkedList<>(firstElement);
        assertEquals(firstElement, list.getFirst());
    }
}
