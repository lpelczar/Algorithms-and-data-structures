import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void whenGetValueAndValueNotInHashMapThenThrowException() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        assertThrows(IllegalArgumentException.class, () -> hashMap.getValue("test"));
    }

    @Test
    void whenGetValueThenReturnCorrectValue() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.add("Test1", 8);
        hashMap.add("Test2", 345);
        assertEquals(new Integer(345), hashMap.getValue("Test2"));
    }

    @Test
    void whenRemoveAndElementNotExistReturnFalse() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        assertFalse(hashMap.remove("test"));
    }

    @Test
    void whenRemoveThenRemoveElementAndReturnTrue() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.add("Test1", 8);
        hashMap.add("Test2", 345);
        String expected = " Test1 : 8";
        assertTrue(hashMap.remove("Test2"));
        assertEquals(expected, hashMap.toString());
    }

    @Test
    void whenRemoveMultipleTimesThenElementsAreProperlyRemoved() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.add("Test1", 8);
        hashMap.add("Test2", 345);
        hashMap.remove("Test1");
        hashMap.remove("Test2");
        assertEquals("", hashMap.toString());
    }

    @Test
    void whenClearAllThenMapIsCleared() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.add("Test1", 8);
        hashMap.add("Test2", 345);
        hashMap.clearAll();
        assertEquals("", hashMap.toString());
    }

    @Test
    void givenEmptyHashMapWhenIsEmptyCalledThenReturnTrue() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        assertTrue(hashMap.isEmpty());
    }

    @Test
    void givenNotEmptyHashMapWhenIsEmptyCalledThenReturnFalse() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.add("Test1", 8);
        assertFalse(hashMap.isEmpty());
    }

    @Test
    void givenEmptyHashMapWhenSizeThenReturn0() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        assertEquals(0, hashMap.size());
    }

    @Test
    void givenNotEmptyHashMapWhenSizeThenReturnCorrectSize() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.add("Test1", 8);
        hashMap.add("Test2", 345);
        hashMap.remove("Test1");
        assertEquals(1, hashMap.size());
    }
}
