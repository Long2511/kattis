package Week3.H;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeReduction {
    public static boolean isPrime(long n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (long i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

    public static List<Long> primeFactors(long n) {
        List<Long> factors = new ArrayList<>();
        while (n % 2 == 0) {
            factors.add(2L);
            n /= 2;
        }
        for (long i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 2) {
            factors.add(n);
        }
        return factors;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLong()) {
            long x = scanner.nextLong();
            if (x == 4) break;
            int steps = 0;

            while (!isPrime(x)) {
                List<Long> factors = primeFactors(x);
                x = factors.stream().mapToLong(Long::longValue).sum();
                steps++;
            }
            System.out.println(x + " " + (steps + 1));
        }
        scanner.close();
    }
}
