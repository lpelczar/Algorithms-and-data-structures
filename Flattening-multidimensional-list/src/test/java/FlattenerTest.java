import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FlattenerTest {

    @Test
    void whenPerformCalledOnMultidimensionalListThenReturnFlattenedList() {

        List nestedList = asList(1, 3, asList("age", 5), "Kraków", asList(1, asList(3, asList(4, 5), "codecool"), 6 ,7));
        Flattener flattener = new Flattener();
        List flattened = flattener.perform(nestedList);
        String expected = "[1, 3, age, 5, Kraków, 1, 3, 4, 5, codecool, 6, 7]";
        assertEquals(expected, flattened.toString());
    }

    @Test
    void whenPerformCalledOnFlatListThenReturnThisList() {
        List list = asList(1, 3, "codecool", 5, 8);
        Flattener flattener = new Flattener();
        List flattened = flattener.perform(list);
        assertEquals(list.toString(), flattened.toString());
    }

}
