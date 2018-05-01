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
}
