import java.util.HashMap;
import java.util.Map;

public class FizzBuzz {

    public static void main(String... args) {

        Map<Integer, String> pairs = new HashMap<>();
        pairs.put(3, "Fizz");
        pairs.put(5, "Buzz");
        pairs.put(7, "Bum");

        new FizzBuzz().perform(100, pairs);
    }

    private void perform(int numbers, Map<Integer, String> pairs) {
        for (int i = 1; i <= numbers; i++) {
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(i));
            for (Map.Entry<Integer, String> entry : pairs.entrySet()) {
                if (i % entry.getKey() == 0) {
                    stringBuilder.append(" ");
                    stringBuilder.append(entry.getValue());
                }
            }
            System.out.println(stringBuilder.toString());
        }
    }
}
