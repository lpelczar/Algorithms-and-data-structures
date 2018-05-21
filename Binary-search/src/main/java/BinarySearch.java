
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class BinarySearch {

    Integer search(List<Integer> sortedList, int item) {

        if (!isSorted(sortedList)) {
            throw new IllegalArgumentException("List is not sorted!");
        }

        int low = 0;
        int high = sortedList.size() - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;
            System.out.println(mid);
            int element = sortedList.get(mid);

            if (element == item) {
                return mid;
            } else if (element > item) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    private boolean isSorted(List<Integer> sortedList) {
        List<Integer> tmp = new ArrayList<>(sortedList);
        Collections.sort(tmp);
        return tmp.equals(sortedList);
    }
}
