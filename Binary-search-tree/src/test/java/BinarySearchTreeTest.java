import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTreeTest {

    @Test
    void whenCreateTreeFromArrayThenBSTisProperlyCreated() {
        BinarySearchTree binarySearchTree = BinarySearchTree.fromArray(new Integer[] {1,2,3,4,5,6,7});
        String expected = " 1 2 3 4 5 6 7";
        assertEquals(expected, binarySearchTree.toString());
    }
}
