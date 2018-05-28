import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArabicRomanConverterTest {

    @Test
    void convertToRomanTest() {
        ArabicRomanConverter arabicRomanConverter = new ArabicRomanConverter();
        String result = arabicRomanConverter.convertToRoman(1982);
        String expected = "MCMLXXXII";
        assertEquals(expected, result);
    }
}
