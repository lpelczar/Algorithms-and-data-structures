import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinHeapTest {

    @Test
    void whenAddThenElementIsAdded() {
        MinHeap minHeap = new MinHeap();
        minHeap.add(1);
        String expected = " 1";
        assertEquals(expected, minHeap.toString());
    }

    @Test
    void whenAddMultipleTimesThenElementsAreProperlyAdded() {
        MinHeap minHeap = new MinHeap();
        minHeap.add(1);
        minHeap.add(3);
        minHeap.add(8);
        minHeap.add(2);
        minHeap.add(5);
        minHeap.add(17);
        String expected = " 1 2 8 3 5 17";
        assertEquals(expected, minHeap.toString());
    }

    @Test
    void whenPeekThenReturnFirstElement() {
        MinHeap minHeap = new MinHeap();
        minHeap.add(8);
        minHeap.add(2);
        assertEquals(2, minHeap.peek());
    }

    @Test
    void whenPollThenGetFirstElementAndRemoveItFromHeap() {
        MinHeap minHeap = new MinHeap();
        minHeap.add(1);
        minHeap.add(3);
        minHeap.add(8);
        minHeap.add(2);
        minHeap.add(5);
        minHeap.add(17);
        assertEquals(1, minHeap.poll());
        String expected = " 2 3 8 17 5";
        assertEquals(expected, minHeap.toString());
    }
}
