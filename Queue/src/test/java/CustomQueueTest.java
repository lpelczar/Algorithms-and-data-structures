import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
