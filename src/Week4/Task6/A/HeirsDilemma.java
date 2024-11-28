
/**
 * Advanced Object Oriented Programming with Java, WiSe 2023/2024
 * Problem: <a href="https://open.kattis.com/problems/heirsdilemma">Heir's Dilemma</a>
 * @author Hai Long Mac
 *
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.24
 */
package Week4.Task6.A;

import java.util.Scanner;

public class HeirsDilemma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int L = scanner.nextInt();
        int H = scanner.nextInt();
        scanner.close();

        System.out.println(countValidNumbers(L, H));
    }

    // Method to count valid numbers in the given range [L, H]
    public static int countValidNumbers(int L, int H) {
        int count = 0;
        for (int num = L; num <= H; num++) {
            if (isValidNumber(num)) {
                count++;
            }
        }
        return count;
    }

    // Method to check if a number meets the criteria
    public static boolean isValidNumber(int num) {
        String digits = String.valueOf(num);

        // Condition 1: Check if it has 6 digits and contains no zeros
        if (digits.length() != 6 || digits.contains("0")) {
            return false;
        }

        // Condition 2: Check if all digits are unique
        if (hasDuplicateDigits(digits)) {
            return false;
        }

        // Condition 3: Check if the number is divisible by each of its digits
        for (char c : digits.toCharArray()) {
            int digit = Character.getNumericValue(c);
            if (digit == 0 || num % digit != 0) {
                return false;
            }
        }

        return true;
    }

    // Helper method to check for duplicate digits
    public static boolean hasDuplicateDigits(String digits) {
        boolean[] seen = new boolean[10]; // Array to mark seen digits
        for (char c : digits.toCharArray()) {
            int digit = c - '0';
            if (seen[digit]) {
                return true; // Duplicate found
            }
            seen[digit] = true;
        }
        return false;
    }
}