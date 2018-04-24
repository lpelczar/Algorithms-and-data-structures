import java.util.ArrayList;
import java.util.List;

class PrimeFactorization {

    int[] performFactorization(int number) {

        List<Integer> result = new ArrayList<>();
        double num = (double) number;

        int currentNum = (int) num;

        int divisor = 1;
        while (!isPrime(currentNum)) {
            divisor++;
            if (isPrime(divisor)) {
                if (currentNum % divisor == 0) {
                    currentNum = currentNum / divisor;
                    result.add(divisor);
                    divisor = 1;
                }
            }
        }
        result.add(currentNum);

        return result.stream().mapToInt(i -> i).toArray();
    }

    private boolean isPrime(int number) {
        boolean isPrime = true;
        for (int divisor = 2; divisor <= number / 2; divisor++) {
            if (number % divisor == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
}
