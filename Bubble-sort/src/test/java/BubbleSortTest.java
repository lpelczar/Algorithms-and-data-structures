import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BubbleSortTest {

    @Test
    void bubbleSortTest1() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] elements = new int[] {2};
        String expected = "[2]";

        String result = Arrays.toString(bubbleSort.sort(elements));

        assertEquals(expected, result);
    }

    @Test
    void bubbleSortTest2() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] elements = new int[] {};
        String expected = "[]";

        String result = Arrays.toString(bubbleSort.sort(elements));

        assertEquals(expected, result);
    }

    @Test
    void bubbleSortTest3() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] elements = new int[] {33,6,2,43,2323};
        String expected = "[2, 6, 33, 43, 2323]";

        String result = Arrays.toString(bubbleSort.sort(elements));

        assertEquals(expected, result);
    }
}
