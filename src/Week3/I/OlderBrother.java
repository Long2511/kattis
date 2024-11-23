
/**
 * Advanced Object Oriented Programming with Java, WiSe 2023/2024
 * Problem: <a href="https://open.kattis.com/problems/olderbrother">Older Brother</a>
 * @author Hai Long Mac
 *
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.10
 */
package Week3.I;

import java.util.Scanner;

public class OlderBrother {
    public static boolean isPrime(long n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (long i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

    public static boolean isPrimePower(long q) {
        if (q < 2) return false;

        for (long p = 2; p * p <= q; p++) {
            if (isPrime(p)) {
                long power = p;
                while (power <= q) {
                    power *= p;
                    if (power == q) {
                        return true;
                    }
                }
            }
        }

        if (isPrime(q)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long q = scanner.nextLong();
        if (isPrimePower(q)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
        scanner.close();
    }
}