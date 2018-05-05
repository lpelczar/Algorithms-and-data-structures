import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HashMapTest {

    @Test
     void givenEmptyHashMapWhenToStringCalledThenReturnEmptyString() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        assertEquals("", hashMap.toString());
    }

    @Test
    void whenAddElementThenItIsAdded() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.add("Test", 8);
        String expected = " Test : 8";
        assertEquals(expected, hashMap.toString());
    }

    @Test
    void whenAddMultipleElementsThenTheyAreProperlyAdded() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.add("Test1", 8);
        hashMap.add("Test2", 345);
        String expected = " Test2 : 345 Test1 : 8";
        assertEquals(expected, hashMap.toString());
    }
}
