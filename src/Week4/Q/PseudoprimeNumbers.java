
/**
 * Advanced Object Oriented Programming with Java, WiSe 2023/2024
 * Problem: <a href="https://open.kattis.com/problems/pseudoprime">Pseudoprime numbers</a>
 * @author Hai Long Mac
 *
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.10
 */
package Week4.Q;

import java.util.Scanner;

public class PseudoprimeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            long prime = scanner.nextLong();
            long base = scanner.nextLong();

            if (prime == 0 && base == 0) {
                break;
            }

            if (fastPow(base, prime, prime) == base && !isPrime(prime)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
        scanner.close();
    }

    static long fastPow(long base, long exp, long mod) {
        long res = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }
        return res % mod;
    }

    static boolean isPrime(long n) {
        if (n == 2) {
            return true;
        }
        if (n < 2) {
            return false;
        }
        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
