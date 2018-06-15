import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SumInArrayTest {


    @Test
    void numbersSumTest() {
        SumInArray sumInArray = new SumInArray();
        int[] numbers = {1, 15, 8, 2};
        assertTrue(sumInArray.sumOfTwo(numbers, 16));
        assertFalse(sumInArray.sumOfTwo(numbers, 2));
    }

    @Test
    void sumOfThreeTest() {
        SumInArray sumInArray = new SumInArray();
        int[] numbers = {1, 15, 8, 2};
        assertTrue(sumInArray.sumOfThree(numbers, 18));
        assertFalse(sumInArray.sumOfThree(numbers, 2));
    }
}
