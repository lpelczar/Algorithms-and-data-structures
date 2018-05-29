import java.util.HashMap;

class Fibonacci {

    private HashMap<Long, Long> cache = new HashMap<>();

    // Time complexity: O(2^n)
    long fibonacciRecursion(long n)  {
        if (n < 0) {
            throw new IllegalArgumentException();
        } else if (n == 0 || n == 1) {
            return 1;
        } else {
            return fibonacciRecursion(n - 2) + fibonacciRecursion(n - 1);
        }
    }

    // Time complexity : O(n), Space complexity : O(n)
    long fibonacciRecursionWithHashMap(long n)  {

        if (n < 0) {
            throw new IllegalArgumentException();
        } else if (n == 0 || n == 1) {
            return 1;
        } else {
            if (cache.get(n) != null) {
                return cache.get(n);
            } else {
                long result = fibonacciRecursionWithHashMap(n - 2) + fibonacciRecursionWithHashMap(n - 1);
                cache.put(n, result);
                return result;
            }
        }
    }

    // Time complexity: O(n), Space complexity: O(1)
    long fibbonaciIterate(long n) {

        if (n < 0) {
            throw new IllegalArgumentException();
        } else if (n == 0 || n == 1) {
            return 1;
        } else {
            long prev = 0, next = 1, current = 0;
            for (long i = 1; i < n; i++) {
                current = prev + next;
                prev = next;
                next = current;
            }
            return current;
        }
    }

    // There is a formula for getting n'th element of Fibonacci.
}
