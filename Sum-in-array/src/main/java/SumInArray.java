import java.util.Arrays;

class SumInArray {

    /*
     * Given an array A[] and a number x, check for pair of integers in A[] with sum as x. For example, we've got an
     * array [1, 4, 45, 6, 10, -8] and a number x = 16. Does that array contain two integers that sum up to x?
     */
    boolean sumOfTwo(int[] array, int x) {

        Arrays.sort(array);

        if (array.length < 2) {
            throw new IllegalArgumentException();
        }

        int leftIndex = 0;
        int rightIndex = array.length - 1;

        while (leftIndex < rightIndex) {
            if (array[leftIndex] + array[rightIndex] == x) {
                return true;
            } else if (array[leftIndex] + array[rightIndex] > x) {
                rightIndex--;
            } else {
                leftIndex++;
            }
        }
        return false;
    }

    boolean sumOfThree(int[] array, int x) {

        Arrays.sort(array);

        if (array.length < 3) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < array.length - 2; i++) {

            int leftIndex = i + 1;
            int rightIndex = array.length - 1;

            while (leftIndex < rightIndex) {

                if (array[i] + array[leftIndex] + array[rightIndex] == x) {
                    return true;
                } else if (array[i] + array[leftIndex] + array[rightIndex] > x) {
                    rightIndex--;
                } else {
                    leftIndex++;
                }
            }
        }
        return false;
    }
}
