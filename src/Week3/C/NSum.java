
/**
 * Advanced Object Oriented Programming with Java, WiSe 2023/2024
 * Problem: <a href="https://open.kattis.com/problems/nsum">N-sum</a>
 * @author Hai Long Mac
 *
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.08
 */
package Week3.C;

import java.util.Scanner;

public class NSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        int sum = 0;

        for (int i = 0; i < N; i++) {
            sum += arr[i];
        }

        System.out.println(sum);
    }
}
