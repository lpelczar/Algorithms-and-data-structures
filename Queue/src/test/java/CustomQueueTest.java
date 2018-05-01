import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomQueueTest {

    @Test
    void whenEnqueueThreeTimesThenItemsAreAddedAtTheEnd() {
        CustomQueue<Integer> queue = new CustomQueue<>();
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        String expected = " 2 3 4";
        assertEquals(expected, queue.toString());
    }

    @Test
    void whenPeekThenReturnFirstElement() {
        CustomQueue<Integer> queue = new CustomQueue<>();
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(new Integer(2), queue.peek());
    }

    @Test
    void givenEmptyQueueWhenPeekThenThrowEmptyQueueException() {
        CustomQueue<Integer> queue = new CustomQueue<>();
        assertThrows(EmptyQueue.class, queue::peek);
    }

    @Test
    void givenEmptyQueueWhenDequeueThenEmptyQueueException() {
        CustomQueue<Integer> queue = new CustomQueue<>();
        assertThrows(EmptyQueue.class, queue::dequeue);
    }

    @Test
    void whenDequeueThenElementIsReturned() {
        CustomQueue<Integer> queue = new CustomQueue<>();
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        String expected = " 3 4";
        assertEquals(new Integer(2), queue.dequeue());
        assertEquals(expected, queue.toString());
    }

    @Test
    void givenQueueWithOneElementWhenDequeueThenQueueIsEmpty() {
        CustomQueue<Integer> queue = new CustomQueue<>();
        queue.enqueue(2);
        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    void givenThreeElementsQueueWhenGetSizeThenReturn3() {
        CustomQueue<Integer> queue = new CustomQueue<>();
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(4);
        queue.dequeue();
        assertEquals(3, queue.size());
    }

    @Test
    void givenEmptyQueueWhenGetSizeThenReturn0() {
        CustomQueue<Integer> queue = new CustomQueue<>();
        assertEquals(0, queue.size());
    }

    @Test
    void whenAddElementsWithDifferentPriorityThenElementsAreProperlyAdded() {
        CustomQueue<Integer> queue = new CustomQueue<>();
        queue.enqueue(2, 1);
        queue.enqueue(3, 1);
        queue.enqueue(8, 3);
        queue.enqueue(4, 2);
        queue.enqueue(16, 100);
        queue.enqueue(32, 50);
        queue.enqueue(256, 2);
        String expected = " 16 32 8 4 256 2 3";
        assertEquals(expected, queue.toString());
    }

    @Test
    void whenAddElementsWithDifferentPriorityAndDequeueThenElementsAreProperlyAdded() {
        CustomQueue<Integer> queue = new CustomQueue<>();
        queue.enqueue(2, 1);
        queue.enqueue(3, 1);
        queue.enqueue(16, 100);
        queue.enqueue(32, 50);
        queue.dequeue();
        queue.enqueue(256, 2);

        String expected = " 32 256 2 3";
        assertEquals(expected, queue.toString());
    }
}
