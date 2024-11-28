
/**
 * Advanced Object Oriented Programming with Java, WiSe 2023/2024
 * Problem: <a href="https://open.kattis.com/problems/veci">Veci</a>
 * @author Hai Long Mac
 *
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.09
 */
package Week3.Task4.F;

import java.util.Scanner;

public class Veci {
    public static int[] toDigitArray(int num) {
        String str = Integer.toString(num);
        int[] digits = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            digits[i] = str.charAt(i) - '0';
        }
        return digits;
    }

    public static int toNumber(int[] digits) {
        StringBuilder sb = new StringBuilder();
        for (int digit : digits) {
            sb.append(digit);
        }
        return Integer.parseInt(sb.toString());
    }

    public static boolean nextPermutation(int[] digits) {
        int n = digits.length;
        int i = n - 2;
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }

        if (i < 0) {
            return false;
        }

        int j = n - 1;
        while (digits[j] <= digits[i]) {
            j--;
        }

        int temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;

        int start = i + 1;
        int end = n - 1;
        while (start < end) {
            temp = digits[start];
            digits[start] = digits[end];
            digits[end] = temp;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt();
        int[] digits = toDigitArray(X);

        if (nextPermutation(digits)) {
            int result = toNumber(digits);
            System.out.println(result);
        } else {
            System.out.println(0);
        }

        scanner.close();
    }
}
