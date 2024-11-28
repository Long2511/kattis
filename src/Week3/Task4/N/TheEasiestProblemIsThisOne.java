
/**
 * Advanced Object Oriented Programming with Java, WiSe 2023/2024
 * Problem: <a href="https://open.kattis.com/problems/easiest">The Easiest Problem Is This One</a>
 * @author Hai Long Mac
 *
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.17
 */
package Week3.Task4.N;

import java.util.Scanner;

public class TheEasiestProblemIsThisOne {
    public static int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int N = scanner.nextInt();
            if (N == 0) {
                break;
            }

            int originalSum = sumOfDigits(N);
            int p = 11;

            while (true) {
                int product = N * p;
                if (sumOfDigits(product) == originalSum) {
                    System.out.println(p);
                    break;
                }
                p++;
            }
        }

        scanner.close();
    }
}
