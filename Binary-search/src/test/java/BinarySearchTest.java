import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BinarySearchTest {

    @Test
    void whenListNotSortedThenThrowException() {
        BinarySearch binarySearch = new BinarySearch();
        List<Integer> list = Arrays.asList(1,3,4,2);
        assertThrows(IllegalArgumentException.class, () -> binarySearch.search(list, 3));
    }

    @Test
    void whenSearchingElementOutsideListThenReturnMinusOne() {
        BinarySearch binarySearch = new BinarySearch();
        List<Integer> list = Arrays.asList(1,2,3,4,6,70,3434,34344);
        Integer result = -1;
        assertEquals(result, binarySearch.search(list, 2323));
    }

    @Test
    void whenSearchElementInTheMiddleThenReturnCorrectIndex() {
        BinarySearch binarySearch = new BinarySearch();
        List<Integer> list = Arrays.asList(1,2,3,4,6,70,3434,34344);
        Integer result = 4;
        assertEquals(result, binarySearch.search(list, 6));
    }

    @Test
    void whenSearchFirstElementThenReturnCorrectIndex() {
        BinarySearch binarySearch = new BinarySearch();
        List<Integer> list = Arrays.asList(1,2,3,4,6,70,3434,34344);
        Integer result = 0;
        assertEquals(result, binarySearch.search(list, 1));
    }

    @Test
    void whenSearchLastElementThenReturnCorrectIndex() {
        BinarySearch binarySearch = new BinarySearch();
        List<Integer> list = Arrays.asList(1,2,3,4,6,70,3434,34344);
        Integer result = 7;
        assertEquals(result, binarySearch.search(list, 34344));
    }
}
