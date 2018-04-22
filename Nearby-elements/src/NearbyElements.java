import java.util.ArrayList;
import java.util.List;

class NearbyElements {

    private int[][] multi = new int[][]{
            { 2, 0, 4, 1241, 12, 5, 11, 1110, -42, 424, 1, 12323 },
            { 1, 3, 5, 7 },
            { 321, 320, 32, 3, 41241, -11, -12, -13, -66, -688 }
    };

    int[] nearby(int x, int y, int range) {

        List<Integer> result = new ArrayList<>();

        if (x >= 0 && x < multi.length) {

            for (int i = range; i >= 1; i--) {
                if (isElementExists(multi[x], y - i)) {
                    result.add(multi[x][y - i]);
                }
            }
            for (int i = 1; i <= range; i++) {
                if (isElementExists(multi[x], y + i)) {
                    result.add(multi[x][y + i]);
                }
            }
        } else {
            throw new IllegalArgumentException("X out of array bounds!");
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    private boolean isElementExists(int[] array, int index){

        try {
            int i = array[index];
            return true;
        } catch(ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }
}
