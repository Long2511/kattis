
/**
 * Advanced Object Oriented Programming with Java, WiSe 2023/2024
 * Problem: <a href="https://open.kattis.com/problems/meowfactor">Meow Factor</a>
 * @author Hai Long Mac
 *
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.10
 */
package Week3.Task4.K;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MeowFactor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();

        Map<Long, Long> factors = factor(n);
        long ans = 1;
        for (Map.Entry<Long, Long> entry : factors.entrySet()) {
            while (entry.getValue() >= 9) {
                entry.setValue(entry.getValue() - 9);
                ans *= entry.getKey();
            }
        }
        System.out.println(ans);
        scanner.close();
        
    }

    public static Map<Long, Long> factor(long n) {
        Map<Long, Long> factorMap = new HashMap<>();
        for (long i = 2; i <= Math.min((long) Math.sqrt(n), 100000L); i++) {
            while (n % i == 0) {
                factorMap.put(i, factorMap.getOrDefault(i, 0L) + 1);
                n /= i;
            }
        }
        if (n > 1) {
            factorMap.put(n, factorMap.getOrDefault(n, 0L) + 1);
        }
        return factorMap;
    }
}
