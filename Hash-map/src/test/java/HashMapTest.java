import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HashMapTest {

    @Test
     void givenEmptyHashMapWhenToStringCalledThenReturnEmptyString() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        assertEquals("", hashMap.toString());
    }
}
