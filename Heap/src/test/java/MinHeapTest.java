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
}
