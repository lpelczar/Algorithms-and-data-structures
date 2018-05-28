import javafx.util.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SimpleAlgorithmsTest {

    private SimpleAlgorithms simpleAlgorithms;

    @BeforeEach
    void before() {
        simpleAlgorithms = new SimpleAlgorithms();
    }

    @Test
    void reverseStringTest() {
        String result = simpleAlgorithms.reverseString("Zebra");

        String expected = "arbeZ";
        assertEquals(expected, result);
    }

    @Test
    void factorializeNumberTest() {
        long result = simpleAlgorithms.factorializeNumber(5);

        assertEquals(120, result);
    }

    @Test
    void isPalindromeTest() {
        boolean result = simpleAlgorithms.isPalindrome("A man, a plan, a canal. Panama");
        assertTrue(result);
    }

    @Test
    void findLongestWordTest() {
        Pair<Integer, String> result = simpleAlgorithms.findLongestWord(
                "What is the average airspeed velocity of an unladen swallow");
        Pair<Integer, String> expected = new Pair<>(8, "airspeed");
        assertEquals(expected, result);
    }

    @Test
    void titleCaseASentence() {
        String result = simpleAlgorithms.titleCaseASentence("I'm a little tea pot");
        String expected =  "I'm A Little Tea Pot";
        assertEquals(expected, result);
    }

    @Test
    void titleCaseASentenceTest2() {
        String result = simpleAlgorithms.titleCaseASentence("HERE IS MY HANDLE HERE IS MY SPOUT");
        String expected = "Here Is My Handle Here Is My Spout";
        assertEquals(expected, result);
    }
}
