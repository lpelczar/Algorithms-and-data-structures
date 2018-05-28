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
        StringBuilder romanBuilder = new StringBuilder();
        int counter = 0;
        while (number > 0) {
            while (constants.get(counter).getKey() > number) {
                counter++;
            }
            romanBuilder.append(constants.get(counter).getValue());
            number -= constants.get(counter).getKey();
        }
        return romanBuilder.toString();
    }
}
