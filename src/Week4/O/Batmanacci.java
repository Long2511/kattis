package Week4.O;

import java.util.Scanner;

public class Batmanacci {
    static long[] fib = new long[100100];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long k = scanner.nextLong();
        scanner.close();

        // Precompute Fibonacci values
        fib[1] = 1;
        fib[2] = 1;
        for (int i = 3; i < 100100; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
            if (fib[i] > 1_000_000_000_000_000_000L) {
                fib[i] = 1_000_000_000_000_000_001L;
            }
        }

        String result = generateSequence(n, k);
        System.out.println(result);
    }

    static String generateSequence(long len, long k) {
        if (len == 1) {
            return "N";
        } else if (len == 2) {
            return "A";
        } else {
            long l = fib[(int) (len - 2)];
            if (k <= l) {
                return generateSequence(len - 2, k);
            } else {
                return generateSequence(len - 1, k - l);
            }
        }
    }
}
