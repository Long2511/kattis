/**
 * Advanced Object Oriented Programming with Java, WiSe 2024/2025
 * Problem: Marching Orders
 * Link: https://open.kattis.com/contests/p6fq6m/problems/marchingorders
 *
 * @author Mac Hai Long
 * @version 1.0, 11/27/2024
 * Method : Modulo Inverse, Chinese Remainder Theorem, Prime Factorization
 * Status : Accepted
 * Runtime: 0.10
 * Ref: https://cp-algorithms.com/algebra/chinese-remainder-theorem.html
 */

package Week5.L;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MarchingOrders {
    public static int[] Factorize(int n) {
        ArrayList<Integer> primeFactors = new ArrayList<>();

        // Handle factorization by checking divisibility by prime numbers
        for (int i = 2; i <= n; i++) {
            if (n % i != 0) continue;
            primeFactors.add(i);
            while (n % i == 0) {
                n /= i;
            }
        }
        // Convert the list to an array
        return primeFactors.stream().mapToInt(i -> i).toArray();
    }

    // Function to calculate modular inverse using Extended Euclidean Algorithm
    public static long CalculateModInverse(long a, long m) {
        long[] result = ExtendedGCD(a, m);
        return (result[1] % m + m) % m;  // Ensure positive result
    }

    // Function to solve the system of congruences
    public static long ChineseRemainder(long[] a, long[] m) {
        long M = 1;
        for (long mod : m) {
            M *= mod;
        }

        long result = 0;
        for (int i = 0; i < a.length; i++) {
            long Mi = M / m[i];
            result = (result + (((a[i] * Mi) % M) * CalculateModInverse(Mi, m[i])) % M) % M;
        }

        return result % M;
    }

    // Extended Euclidean Algorithm
    public static long[] ExtendedGCD(long a, long b) {
        if (b == 0) {
            return new long[]{a, 1, 0};
        } else {
            long[] result = ExtendedGCD(b, a % b);
            long gcd = result[0];
            long x = result[2];
            long y = result[1] - (a / b) * result[2];
            return new long[]{gcd, x, y};
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();
        String order = scanner.nextLine();
        scanner.close();

        // Initialize alphabet and working list
        List<Character> alphabet = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            alphabet.add((char) ('A' + i));
        }
        int[] remainders = new int[n + 1];

        // Reverse simulation
        List<Character> currentList = new ArrayList<>(alphabet);
        for (char professor : order.toCharArray()) {
            int position = currentList.indexOf(professor);
            if (position == -1) {
                System.out.println("NO");
                return;
            }
            remainders[currentList.size()] = position;
            currentList.remove(position);
        }

        boolean[] marked = new boolean[n + 1];

        List<Integer> newModuli = new ArrayList<>();
        List<Integer> newRemainders = new ArrayList<>();

        // Applied Chinese Remainder Theorem for Non-Coprime Moduli
        for (int moduli = n; moduli >= 1; moduli--) {
            int[] factors = Factorize(moduli);

            if (factors.length == 1 && !marked[factors[0]]) {  // only keep the modulo that is p^n with highest n
                marked[factors[0]] = true;
                newModuli.add(moduli);
                newRemainders.add(remainders[moduli]);
            }
            for (int otherModuli = 1; otherModuli < moduli; otherModuli++) {
                if (moduli % otherModuli != 0) continue;  // Not a factor
                if (remainders[otherModuli] != remainders[moduli] % otherModuli) {  // Contradiction
                    System.out.println("NO");
                    return;
                }
            }
        }

        // Convert remainders and moduli to arrays for CRT
        long[] remainderArray = newRemainders.stream().mapToLong(i -> i).toArray();
        long[] moduliArray = newModuli.stream().mapToLong(i -> i).toArray();

        // Solve using CRT
        Long k = ChineseRemainder(remainderArray, moduliArray);
        System.out.println("YES");
        System.out.println(k);
    }
}