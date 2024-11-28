
/**
 * Advanced Object Oriented Programming with Java, WiSe 2023/2024
 * Problem: <a href="https://open.kattis.com/problems/fundamentalneighbors">Fundamental Neighbors</a>
 * @author Hai Long Mac
 *
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.78
 */
package Week3.Task4.G;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class FundamentalNeighbors {
    public static Map<Integer, Integer> primeFactorization(int n) {
        Map<Integer, Integer> primeFactors = new TreeMap<>();
        int count = 0;
        while (n % 2 == 0) {
            count++;
            n /= 2;
        }
        if (count > 0) {
            primeFactors.put(2, count);
        }

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            count = 0;
            while (n % i == 0) {
                count++;
                n /= i;
            }
            if (count > 0) {
                primeFactors.put(i, count);
            }
        }

        if (n > 2) {
            primeFactors.put(n, 1);
        }

        return primeFactors;
    }

    public static long calculateNeighbor(Map<Integer, Integer> primeFactors) {
        long neighbor = 1;
        for (Map.Entry<Integer, Integer> entry : primeFactors.entrySet()) {
            int base = entry.getKey();
            int exponent = entry.getValue();
            neighbor *= (long) Math.pow(exponent, base);
            if (neighbor > Integer.MAX_VALUE) {
                return -1;
            }
        }
        return neighbor;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            Map<Integer, Integer> primeFactors = primeFactorization(n);
            long neighbor = calculateNeighbor(primeFactors);
            if (neighbor > 0 && neighbor <= (1L << 31) - 1) {
                System.out.println(n + " " + neighbor);
            } else {
                System.out.println(n + " 0");
            }
        }
        scanner.close();
    }
}
