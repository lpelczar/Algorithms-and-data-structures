import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        assertTrue(binarySearchTree.contains(3));
    }

    @Test
    void whenSearchFor5ThenReturnTrue() {
        BinarySearchTree binarySearchTree = BinarySearchTree.fromArray(new Integer[] {1,2,3,4,5,6,7});
        assertTrue(binarySearchTree.contains(5));
    }

    @Test
    void whenSearchFor8ThenReturnFalse() {
        BinarySearchTree binarySearchTree = BinarySearchTree.fromArray(new Integer[] {1,2,3,4,5,6,7});
        assertFalse(binarySearchTree.contains(8));
    }

    @Test
    void whenAddNumberAtTheLeafThenItIsProperlyAdded() {
        BinarySearchTree binarySearchTree = BinarySearchTree.fromArray(new Integer[] {1,2,3,4,5,6,7});
        binarySearchTree.add(8);
        String expected = " 1 2 3 4 5 6 7 8";
        assertEquals(expected, binarySearchTree.toString());
    }

    @Test
    void whenAddNumberInTheMiddleOfTheTreeThenNumberIsProperlyAdded() {
        BinarySearchTree binarySearchTree = BinarySearchTree.fromArray(new Integer[] {1,2,4,5,6,7});
        binarySearchTree.add(3);
        String expected = " 1 2 3 4 5 6 7";
        assertEquals(expected, binarySearchTree.toString());
    }

    @Test
    void whenAddNumberAndNumberAlreadyExistsThrowException() {
        BinarySearchTree binarySearchTree = BinarySearchTree.fromArray(new Integer[] {1,2,4,5,6,7});
        assertThrows(IllegalArgumentException.class, () -> binarySearchTree.add(2));
    }
}
