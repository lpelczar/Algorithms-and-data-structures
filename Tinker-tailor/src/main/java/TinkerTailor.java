
import java.util.*;

public class TinkerTailor {

    List<Integer> perform(int n, int k) {

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        int counter = 0;
        while (!queue.isEmpty()) {
            counter++;
            Integer element = queue.remove();

            if (counter == k) {
                counter = 0;
                result.add(element);
            } else {
                queue.add(element);
            }
        }
        return result;
    }
}
