public class HighestProduct {

    long calculateHighestOfTwo(long[] numbers) {

        // GREEDY algorithm, Time complexity O(n), Space complexity: O(1)
        long firstMax = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        long firstMin = Long.MAX_VALUE;
        long secondMin = Long.MAX_VALUE;

        for (long current : numbers) {

            if (current > 0) {
                if (current > firstMax) {
                    secondMax = firstMax;
                    firstMax = current;
                } else if (current > secondMax) {
                    secondMax = current;
                }
            }

            if (current < 0) {
                if (current < firstMin) {
                    secondMin = firstMin;
                    firstMin = current;
                } else if (current < secondMin) {
                    secondMin = current;
                }
            }

        }

        long maxNumbersProduct = firstMax * secondMax;
        long minNumbersProduct = firstMin * secondMin;

        return maxNumbersProduct > minNumbersProduct ? maxNumbersProduct : minNumbersProduct;
    }

    long calculateHighestOfThree(long[] numbers) {

        // Time complexity: O(n)
        long firstMax = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;

        long firstMin = Long.MAX_VALUE;
        long secondMin = Long.MAX_VALUE;
        long thirdMin = Long.MAX_VALUE;

        for (long current : numbers) {

            if (current > 0) {
                if (current > firstMax) {
                    thirdMax = secondMax;
                    secondMax = firstMax;
                    firstMax = current;
                } else if (current > secondMax) {
                    thirdMax = secondMax;
                    secondMax = current;
                } else if (current > thirdMax) {
                    thirdMax = current;
                }
            }

            if (current < 0) {
                if (current < firstMin) {
                    thirdMin = secondMin;
                    secondMin = firstMin;
                    firstMin = current;
                } else if (current < secondMin) {
                    thirdMin = secondMin;
                    secondMin = current;
                } else if (current < thirdMin) {
                    thirdMin = current;
                }
            }
        }

        long threePositiveProduct = firstMax * secondMax * thirdMax;
        long onePositiveTwoNegative = firstMax * firstMin * secondMin;

        return threePositiveProduct > onePositiveTwoNegative ? threePositiveProduct : onePositiveTwoNegative;
    }

    long calculateHighestOfThreeIterate(long[] numbers) {

        long max = Long.MIN_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                for (int k = 0; k < numbers.length; k++) {
                    if (i != j && i != k && j != k) {
                        long value = numbers[i] * numbers[j] * numbers[k];
                        if (value > max) {
                            max = value;
                        }
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        HighestProduct highestProduct = new HighestProduct();
        long[] numbers = new long[] {5, 1, 8, 7, 12};
        System.out.println(highestProduct.calculateHighestOfThreeIterate(numbers));
    }
}
