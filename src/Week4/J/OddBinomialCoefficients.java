
/**
 * Advanced Object Oriented Programming with Java, WiSe 2023/2024
 * Problem: <a href="https://open.kattis.com/problems/oddbinom">Odd Binomial Coefficients</a>
 * @author Hai Long Mac
 *
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.09
 */
package Week4.J;

import java.util.Scanner;

public class OddBinomialCoefficients {


    // Method to count the number of 1-bits in the binary representation of a number
    public static int oneBits(long n) {
        // Apply bit manipulation to count 1-bits efficiently
        n -= (n >> 1) & 0x5555555555555555L;
        n = (n & 0x3333333333333333L) + ((n >> 2) & 0x3333333333333333L);
        n = (n + (n >> 4)) & 0x0f0f0f0f0f0f0f0fL;
        return (int) ((n * 0x0101010101010101L) >> 56);
    }

    // Recursive function to calculate the "odds" based on the bitwise structure of n
    public static long odds(long n) {
        // Base case: if n is less than 2, return n
        if (n < 2) return n;

        // Recursive case: calculate odds for half of n, then apply bitwise logic
        return 3 * odds(n >> 1) + ((n % 2 != 0) ? 1L << oneBits(n - 1) : 0L);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the input number
        long n = sc.nextLong();

        // Calculate and print the result
        System.out.println(odds(n));

        sc.close();
    }
}

