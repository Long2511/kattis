/**
 * Advanced Object Oriented Programming with Java, WiSe 2023/2024
 * Problem: <a href="https://open.kattis.com/contests/v499w5/submissions/14727443">Jack-O'-Lantern Juxtaposition</a>
 * @author Hai Long Mac
 *
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.09
 */

package Week1.Task6.E;

import java.util.Scanner;

public class Jack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N, T, M;

        while (true) {
            int input = scanner.nextInt();
            if (input >= 1 && input <= 500) {
                N = input;
                break;
            }
        }

        while (true) {
            int input = scanner.nextInt();
            if (input >= 1 && input <= 500) {
                T = input;
                break;
            }
        }

        while (true) {
            int input = scanner.nextInt();
            if (input >= 1 && input <= 500) {
                M = input;
                break;
            }
        }

        int totalDesign = N * T * M;
        System.out.println(totalDesign);

        scanner.close();
    }
}
