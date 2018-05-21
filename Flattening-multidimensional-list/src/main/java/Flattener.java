import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.*;

public class Flattener {

    List perform(List list) {
        List result = new ArrayList();
        extractElements(list, result);
        return result;
    }

    @SuppressWarnings("unchecked")
    private void extractElements(List list, List result) {
        for (Object element : list) {
            if (element instanceof List) {
                extractElements((List) element, result);
            } else {
                result.add(element);
            }
        }
    }

    public static void main(String[] args) {

        // [ 1, 3, ["age", 5], "Kraków", [1, [3, [4, 5], "codecool"], 6, 7]]
        List nestedList = asList(1, 3, asList("age", 5), "Kraków", asList(1, asList(3, asList(4, 5), "codecool"), 6 ,7));

        Flattener flattener = new Flattener();
        List flattened = flattener.perform(nestedList);
        System.out.println(flattened.toString());
    }
}
