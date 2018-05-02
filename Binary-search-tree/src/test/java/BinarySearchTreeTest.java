import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BinarySearchTreeTest {

    @Test
    void whenCreateTreeFromArrayThenBSTisProperlyCreated() {
        BinarySearchTree binarySearchTree = BinarySearchTree.fromArray(new Integer[] {1,2,3,4,5,6,7});
        String expected = " 1 2 3 4 5 6 7";
        assertEquals(expected, binarySearchTree.toString());
    }

    @Test
    void whenSearchFor3ThenReturnTrue() {
        BinarySearchTree binarySearchTree = BinarySearchTree.fromArray(new Integer[] {1,2,3,4,5,6,7});
        assertTrue(binarySearchTree.search(3));
    }

    @Test
    void whenSearchFor5ThenReturnTrue() {
        BinarySearchTree binarySearchTree = BinarySearchTree.fromArray(new Integer[] {1,2,3,4,5,6,7});
        assertTrue(binarySearchTree.search(5));
    }

    @Test
    void whenSearchFor8ThenReturnFalse() {
        BinarySearchTree binarySearchTree = BinarySearchTree.fromArray(new Integer[] {1,2,3,4,5,6,7});
        assertFalse(binarySearchTree.search(8));
    }
}
