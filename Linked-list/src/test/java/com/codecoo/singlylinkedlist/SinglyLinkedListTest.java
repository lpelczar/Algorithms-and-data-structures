package com.codecoo.singlylinkedlist;

import com.codecool.singlylinkedlist.SinglyLinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class SinglyLinkedListTest {

    @Test
    void whenInstantiatedThenHeadIsProperlyDefined() {
        Integer firstElement = 0;
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>(firstElement);
        assertEquals(firstElement, list.getFirst());
    }

    @Test
    void whenAddMultipleTimesThenItemsAreProperlyAdded() {
        SinglyLinkedList<Integer> linkedList = createList(11);
        linkedList.add(32);
        linkedList.add(42);
        String result = " 0 1 2 3 4 5 6 7 8 9 10 32 42";
        assertEquals(result, linkedList.toString());
    }

    @Test
    void whenGetLastThenReturnLast() {
        SinglyLinkedList<Integer> linkedList = createList(11);
        assertEquals(new Integer(10), linkedList.getLast());
    }

    @Test
    void whenAddAsFirstThenChangeHead() {
        SinglyLinkedList<Integer> linkedList = createList(11);
        linkedList.addAsFirst(890);
        String result = " 890 0 1 2 3 4 5 6 7 8 9 10";
        assertEquals(result, linkedList.toString());
        assertEquals(new Integer(890), linkedList.getFirst());
    }

    @Test
    void whenElementsAddedThenReturnAppropriateLength() {
        SinglyLinkedList<Integer> linkedList = createList(12);
        linkedList.add(800);
        assertEquals(13, linkedList.size());
    }

    @Test
    void whenClearThenListIsEmpty() {
        SinglyLinkedList<Integer> linkedList = createList(12);
        linkedList.clear();
        assertEquals("", linkedList.toString());
    }

    @Test
    void whenContainsCalledAndElementExistsThenReturnTrue() {
        SinglyLinkedList<Integer> linkedList = createList(12);
        assertTrue(linkedList.contains(11));
    }

    @Test
    void whenContainsCalledAndElementNotExistsThenReturnFalse() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        assertFalse(linkedList.contains(10));
    }

    @Test
    void whenInsertWithInvalidIndex1ThenThrowArrayBoundsException() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> linkedList.insert(-1, 10));
    }

    @Test
    void whenInsertWithInvalidIndex2ThenThrowArrayBoundsException() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> linkedList.insert(20, 10));
    }

    @Test
    void whenInsertItemThenItemIsProperlyInserted() {
        SinglyLinkedList<Integer> linkedList = createList(11);
        linkedList.insert(2, 890);
        String result = " 0 1 890 2 3 4 5 6 7 8 9 10";
        assertEquals(result, linkedList.toString());
    }

    @Test
    void whenInsertAsFirstModifyHead() {
        SinglyLinkedList<Integer> linkedList = createList(11);
        linkedList.insert(0, 890);
        String result = " 890 0 1 2 3 4 5 6 7 8 9 10";
        assertEquals(result, linkedList.toString());
        assertEquals(new Integer(890), linkedList.getFirst());
    }

    @Test
    void whenInsertAsLastThenModifyTail() {
        SinglyLinkedList<Integer> linkedList = createList(11);
        linkedList.insert(11, 890);
        String result = " 0 1 2 3 4 5 6 7 8 9 10 890";
        assertEquals(result, linkedList.toString());
        assertEquals(new Integer(890), linkedList.getLast());
    }

    @Test
    void whenInsertAndListIsEmptyThenAddFirst() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        linkedList.insert(0, 890);
        String result = " 890";
        assertEquals(result, linkedList.toString());
    }

    @Test
    void whenInsertTwoTimesThenValuesAreInsertedCorrectly() {
        SinglyLinkedList<Integer> linkedList = createList(11);
        linkedList.insert(11, 890);
        linkedList.insert(1, 890);
        String result = " 0 890 1 2 3 4 5 6 7 8 9 10 890";
        assertEquals(result, linkedList.toString());
    }

    @Test
    void whenDeleteElementInTheMiddleThenElementIsDeleted() {
        SinglyLinkedList<Integer> linkedList = createList(11);
        linkedList.delete(2);
        assertTrue(linkedList.delete(5));
        String result = " 0 1 3 4 6 7 8 9 10";
        assertEquals(result, linkedList.toString());
    }

    @Test
    void whenDeleteFirstElementThenElementIsDeletedAndHeadUpdated() {
        SinglyLinkedList<Integer> linkedList = createList(11);
        assertTrue(linkedList.delete(0));
        String result = " 1 2 3 4 5 6 7 8 9 10";
        assertEquals(result, linkedList.toString());
        assertEquals(new Integer(1), linkedList.getFirst());
    }

    @Test
    void whenRemoveLastElementThenElementIsRemovedAndTailUpdated() {
        SinglyLinkedList<Integer> linkedList = createList(11);
        linkedList.delete(10);
        String result = " 0 1 2 3 4 5 6 7 8 9";
        assertEquals(result, linkedList.toString());
        assertEquals(new Integer(9), linkedList.getLast());
    }

    @Test
    void whenListIsEmptyThenReturnFalse() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        assertFalse(linkedList.delete(890));
    }

    @Test
    void whenElementNotInTheListThenReturnFalse() {
        SinglyLinkedList<Integer> linkedList = createList(11);
        assertFalse(linkedList.delete(100));
    }

    @Test
    void whenListIsEmptyThenThrowException() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> linkedList.getByIndex(0));
    }

    @Test
    void whenGetByIndexThenElementIsReturned() {
        SinglyLinkedList<Integer> linkedList = createList(11);
        assertEquals(new Integer(2), linkedList.getByIndex(2));
    }

    @Test
    void whenGetLastByIndexThenElementIsReturned() {
        SinglyLinkedList<Integer> linkedList = createList(11);
        assertEquals(new Integer(10), linkedList.getByIndex(10));
    }

    @Test
    void whenGetFirstElementThenElementIsReturned() {
        SinglyLinkedList<Integer> linkedList = createList(11);
        assertEquals(new Integer(0), linkedList.getByIndex(0));
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
