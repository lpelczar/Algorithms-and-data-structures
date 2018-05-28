import javafx.util.Pair;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class SimpleAlgorithms {

    String reverseString(String input) {
        var chars = input.toCharArray();
        var stringBuilder = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            stringBuilder.append(chars[i]);
        }
        return stringBuilder.toString();
    }

    long factorializeNumber(int number) {
        if (number == 0) {
            return 1;
        }
        return number * factorializeNumber(number - 1);
    }

    boolean isPalindrome(String input) {
        String trimmedInput = input.replaceAll("[^A-Za-z0-9]", "");
        String reversed = reverseString(trimmedInput);
        return reversed.equalsIgnoreCase(trimmedInput);
    }

    Pair<Integer, String> findLongestWord(String input) {
        String[] words = input.split(" ");
        Map<Integer, String> wordsLengths = new HashMap<>();
        for (String word : words) {
            wordsLengths.putIfAbsent(word.length(), word);
        }
        int maxKey = Collections.max(wordsLengths.keySet());
        return new Pair<>(maxKey, wordsLengths.get(maxKey));
    }

    String titleCaseASentence(String input) {
        String[] words = input.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= words.length - 1; i++) {
            stringBuilder.append(words[i].substring(0, 1).toUpperCase());
            stringBuilder.append(words[i].substring(1).toLowerCase());
            if (i != words.length - 1) {
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }
}
