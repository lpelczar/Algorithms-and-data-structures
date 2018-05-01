import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StackTest {

    @Test
    void whenInitializedThenCapacityIsSet() {
        Stack<Integer> stack = new Stack<>(5);
        assertEquals(5, stack.getCapacity());
    }

    @Test
    void givenEmptyStackWhenGettingQuantityOfFreeSpacesThenReturnCorrectValue() {
        Stack<Integer> stack = new Stack<>(5);
        assertEquals(5, stack.getFreeSpaceSize());
    }

    @Test
    void whenPushFiveTimesThenElementsAreProperlyPushed() {
        Stack<Integer> stack = new Stack<>(5);
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        String expected = " 0 1 2 3 4";
        assertEquals(expected, stack.toString());
    }

    @Test
    void whenPushFiveTimesThenSizeIncreases() {
        Stack<Integer> stack = new Stack<>(5);
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        assertEquals(5, stack.getSize());
    }

    @Test
    void givenFullStackWhenPushThenStackOverflowException() {
        Stack<Integer> stack = new Stack<>(5);
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        assertThrows(StackOverflow.class, () -> stack.push(8));
    }

    @Test
    void whenPopThenLastElementIsPopped() {
        Stack<Integer> stack = new Stack<>(10);
        stack.push(9);
        stack.push(10);
        stack.push(3);
        System.out.println(stack);
        assertEquals(new Integer(3), stack.pop());
        assertEquals(new Integer(10), stack.pop());
    }

    @Test
    void givenEmptyStackWhenPopThenThrowStackUnderflow() {
        Stack<Integer> stack = new Stack<>(3);
        assertThrows(StackUnderflow.class, stack::pop);
    }

    @Test
    void whenPeekThenElementIsReturnedAndSizeRemainsUnchanged() {
        Stack<Integer> stack = new Stack<>(10);
        stack.push(9);
        stack.push(10);
        stack.push(3);
        assertEquals(new Integer(3), stack.peek());
        assertEquals(3 ,stack.getSize());
    }

    @Test
    void givenEmptyStackWhenIsEmptyMethodCalledThenReturnTrue() {
        Stack<Integer> stack = new Stack<>(10);
        assertTrue(stack.isEmpty());
    }

    @Test
    void givenNotEmptyStackWhenIsEmptyMethodCalledThenReturnFalse() {
        Stack<Integer> stack = new Stack<>(10);
        stack.push(3);
        assertTrue(stack.isEmpty());
    }
}
