import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
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

    @Test
    void convertToArabicTest() {
        ArabicRomanConverter arabicRomanConverter = new ArabicRomanConverter();
        int result = arabicRomanConverter.convertToArabic("MCMLXXXII");
        int expected = 1982;
        assertEquals(expected, result);
    }

    @Test
    void convertToArabicEmptyInputTest() {
        ArabicRomanConverter arabicRomanConverter = new ArabicRomanConverter();
        assertThrows(IllegalArgumentException.class, () -> arabicRomanConverter.convertToArabic(""));
    }

    @Test
    void convertToArabicNullInputTest() {
        ArabicRomanConverter arabicRomanConverter = new ArabicRomanConverter();
        assertThrows(IllegalArgumentException.class, () -> arabicRomanConverter.convertToArabic(null));
    }

    @Test
    void convertToArabicWrongCharactersTest() {
        ArabicRomanConverter arabicRomanConverter = new ArabicRomanConverter();
        assertThrows(IllegalArgumentException.class, () -> arabicRomanConverter.convertToArabic("ABCM"));
    }

    @Test
    void convertToArabicMoreThanThreeTest() {
        ArabicRomanConverter arabicRomanConverter = new ArabicRomanConverter();
        assertThrows(IllegalArgumentException.class, () -> arabicRomanConverter.convertToArabic("MMMMXII"));
    }

    @Test
    void convertToArabicMoreThanThreeTest2() {
        ArabicRomanConverter arabicRomanConverter = new ArabicRomanConverter();
        assertDoesNotThrow(() -> arabicRomanConverter.convertToArabic("DDDDXII"));
    }
}
