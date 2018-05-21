import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class BinarySearchTest {

    @Test
    void whenListNotSortedThenThrowException() {
        BinarySearch binarySearch = new BinarySearch();
        List<Integer> list = Arrays.asList(1,3,4,2);
        assertThrows(IllegalArgumentException.class, () -> binarySearch.search(list, 3));
    }
}
