
/**
 * Advanced Object Oriented Programming with Java, WiSe 2023/2024
 * Problem: <a href="https://open.kattis.com/problems/goldbach">Goldbach's Conjecture</a>
 * @author Hai Long Mac
 *
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.27
 */

package Week3.Task4.A;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Goldbach {
    public static boolean[] sieveOfEratosthenes(int max) {
        boolean[] isPrime = new boolean[max + 1];
        for (int i = 2; i <= max; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i <= max; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }

    public static List<Integer> getPrimesUpTo(int max, boolean[] isPrime) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= max; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }

    public static void findPrimeSumPairs(int x, List<Integer> primes, boolean[] isPrime) {
        List<String> pairs = new ArrayList<>();

        for (int prime : primes) {
            if (prime > x / 2) {
                break;
            }
            if (isPrime[x - prime]) {
                pairs.add(prime + "+" + (x - prime));
            }
        }

        System.out.println(x + " has " + pairs.size() + " representation(s)");
        for (String pair : pairs) {
            System.out.println(pair);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] cases = new int[n];

        for (int i = 0; i < n; i++) {
            cases[i] = scanner.nextInt();
        }

        int maxLimit = 32000;
        boolean[] isPrime = sieveOfEratosthenes(maxLimit);
        List<Integer> primes = getPrimesUpTo(maxLimit, isPrime);

        for (int x : cases) {
            findPrimeSumPairs(x, primes, isPrime);
        }

        scanner.close();
    }
}
