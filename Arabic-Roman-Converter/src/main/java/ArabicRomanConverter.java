import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

class ArabicRomanConverter {

    private List<Pair<Integer, String>> constants = new ArrayList<>();

    ArabicRomanConverter() {
        constants.add(new Pair<>(1000, "M"));
        constants.add(new Pair<>(900, "CM"));
        constants.add(new Pair<>(500, "D"));
        constants.add(new Pair<>(400, "CD"));
        constants.add(new Pair<>(90, "XC"));
        constants.add(new Pair<>(50, "L"));
        constants.add(new Pair<>(40, "XL"));
        constants.add(new Pair<>(10, "X"));
        constants.add(new Pair<>(9, "IX"));
        constants.add(new Pair<>(5, "V"));
        constants.add(new Pair<>(4, "IV"));
        constants.add(new Pair<>(1, "I"));
    }

    String convertToRoman(int number) {
        if (number < 1 || number > 3999) {
            throw new IllegalArgumentException("Number must be between 2 and 3999");
        }

        StringBuilder romanBuilder = new StringBuilder();
        var counter = 0;
        while (number > 0) {
            while (constants.get(counter).getKey() > number) {
                counter++;
            }
            romanBuilder.append(constants.get(counter).getValue());
            number -= constants.get(counter).getKey();
        }
        return romanBuilder.toString();
    }

    int convertToArabic(String input) {
        checkIfInputIsCorrect(input);

        var number = 0;
        while (input.length() > 0) {
            for (var pair : constants) {
                if (input.startsWith(pair.getValue())) {
                    input = input.substring(pair.getValue().length());
                    number += pair.getKey();
                }
            }
        }
        return number;
    }

    private void checkIfInputIsCorrect(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("String is null or empty!");
        }

        if (!input.matches("[MCDLXVI]+")) {
            throw new IllegalArgumentException("String must contain only MCDLXVI characters!");
        }

        if (input.matches(".*M{4,}.*") || input.matches(".*C{4,}.*") ||
            input.matches(".*X{4,}.*") || input.matches(".*I{4,}.*")) {
            throw new IllegalArgumentException("String cannot contain more than three M, C, X or I characters!");
        }

        if (input.matches(".*D{2,}.*") || input.matches(".*L{2,}.*") ||
                input.matches(".*V{2,}.*")) {
            throw new IllegalArgumentException("String cannot contain more than one D, L, V characters!");
        }

        if (input.matches(".*(CM){2,}.*") || input.matches(".*(CD){2,}.*") ||
            input.matches(".*(XC){2,}.*") || input.matches(".*(XL){2,}.*") ||
            input.matches(".*(IX){2,}.*") || input.matches(".*(IV){2,}.*")) {
            throw new IllegalArgumentException("String cannot contain doubles like CMCM, CDCD, XCXC, XLXL, IXIX, IVIV!");
        }

        if (input.contains("VX") || input.contains("IVI") || input.contains("CMM")) {
            throw new IllegalArgumentException("String cannot contain VX, IVI, CMM!");
        }
    }
}