import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StackTest {

    @Test
    void whenInitializedThenCapacityIsSet() {
        Stack<Integer> stack = new Stack<>(5);
        assertEquals(5, stack.getCapacity());
    }
}
