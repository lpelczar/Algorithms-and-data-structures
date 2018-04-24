import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        PrimeFactorization primeFactorization = new PrimeFactorization();
        System.out.println(Arrays.toString(primeFactorization.performFactorization(147)));
        System.out.println(Arrays.toString(primeFactorization.performFactorization(12)));
        System.out.println(Arrays.toString(primeFactorization.performFactorization(330)));
        System.out.println(Arrays.toString(primeFactorization.performFactorization(17)));
        System.out.println(Arrays.toString(primeFactorization.performFactorization(2)));
        System.out.println(Arrays.toString(primeFactorization.performFactorization(48)));
    }
}
