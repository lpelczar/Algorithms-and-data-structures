package com.codecoo.singlylinkedlist;

import com.codecool.singlylinkedlist.Node;
import com.codecool.singlylinkedlist.SinglyLinkedList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class SinglyLinkedListTest {

    @Test
    public void whenInstantiatedThenHeadIsProperlyDefined() {
        Node<String> head = new Node<>("Head data");
        SinglyLinkedList<String> list = new SinglyLinkedList<>(head);
        Node result = list.getFirst();
        assertEquals(head.getData(), result.getData());
    }
}
