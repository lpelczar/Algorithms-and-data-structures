import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TinkerTailorTest {

    @Test
    void whenPerformWithN5AndK3ThenReturnCorrectResult() {
        TinkerTailor tinkerTailor = new TinkerTailor();
        String result = "[3, 1, 5, 2, 4]";
        assertEquals(result, tinkerTailor.perform(5, 3).toString());
    }

    @Test
    void whenPerformWithN2AndK3ThenReturnCorrectResult() {
        TinkerTailor tinkerTailor = new TinkerTailor();
        String result = "[1, 2]";
        assertEquals(result, tinkerTailor.perform(2, 3).toString());
    }

    @Test
    void whenPerformWithN1AndK1ThenReturnCorrectResult() {
        TinkerTailor tinkerTailor = new TinkerTailor();
        String result = "[1]";
        assertEquals(result, tinkerTailor.perform(1, 1).toString());
    }
}
