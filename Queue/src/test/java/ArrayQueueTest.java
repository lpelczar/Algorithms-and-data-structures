import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ArrayQueueTest {

    @Test
    void createQueueTest() {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
    }

    @Test
    void givenEmptyQueueWhenSizeThenSizeIs0() {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        int result = queue.size();
        assertEquals(0, result);
    }

    @Test
    void whenEnqueueThenElementIsAdded() {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        queue.enqueue(10);
        String expected = " 10";
        assertEquals(expected, queue.toString());
    }

    @Test
    void whenEnqueueMultipleTimesThenElementsAreCorrectlyEnqueued() {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        queue.enqueue(10);
        queue.enqueue(16);
        queue.enqueue(18);
        String expected = " 10 16 18";
        assertEquals(expected, queue.toString());
    }

    @Test
    void whenAddThreeElementsThenSizeIs3() {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        queue.enqueue(10);
        queue.enqueue(16);
        queue.enqueue(18);
        int result = queue.size();
        assertEquals(3, result);
    }

    @Test
    void givenEmptyQueueWhenDequeueThenThrowException() {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        assertThrows(EmptyQueue.class, queue::dequeue);
    }

    @Test
    void whenDequeueThenReturnFirstElement() {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        queue.enqueue(10);
        int result = queue.dequeue();
        assertEquals(10, result);
    }

    @Test
    void whenDequeueMultipleTimesThenElementsAreProperlyDequeued() {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        queue.enqueue(10);
        queue.enqueue(18);
        queue.enqueue(19);
        assertEquals(new Integer(10), queue.dequeue());
        assertEquals(new Integer(18), queue.dequeue());
        assertEquals(new Integer(19), queue.dequeue());
    }

    @Test
    void whenEnqueueAndDequeueMultipleTimesThenSizeIs0() {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        queue.enqueue(10);
        queue.enqueue(18);
        queue.enqueue(19);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        assertEquals(0, queue.size());
        assertEquals("", queue.toString());
    }

    @Test
    void whenEnqueueAndDequeueMultipleTimesThenQueueHasCorrectElements() {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        queue.enqueue(10);
        queue.enqueue(18);
        queue.dequeue();
        queue.enqueue(1890);
        queue.enqueue(19);
        queue.dequeue();
        queue.enqueue(18900);
        String expected = " 1890 19 18900";
        assertEquals(expected, queue.toString());
    }

    @Test
    void whenEnqueue100TimesThenSizeIs100() {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 100; i++) {
            queue.enqueue(i);
        }
        assertEquals(100, queue.size());
    }
}
