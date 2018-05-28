import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ArabicRomanConverterTest {

    @Test
    void convertToRomanTest() {
        ArabicRomanConverter arabicRomanConverter = new ArabicRomanConverter();
        String result = arabicRomanConverter.convertToRoman(1982);
        String expected = "MCMLXXXII";
        assertEquals(expected, result);
    }

    @Test
    void convertToRomanNegativeInputTest() {
        ArabicRomanConverter arabicRomanConverter = new ArabicRomanConverter();
        assertThrows(IllegalArgumentException.class, () -> arabicRomanConverter.convertToRoman(-1));
    }

    @Test
    void convertToRomanZeroInputTest() {
        ArabicRomanConverter arabicRomanConverter = new ArabicRomanConverter();
        assertThrows(IllegalArgumentException.class, () -> arabicRomanConverter.convertToRoman(0));
    }

    @Test
    void convertToRomanMaxInputTest() {
        ArabicRomanConverter arabicRomanConverter = new ArabicRomanConverter();
        assertThrows(IllegalArgumentException.class, () -> arabicRomanConverter.convertToRoman(4000));
    }
}
