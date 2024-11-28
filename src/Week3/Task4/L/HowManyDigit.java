
/**
 * Advanced Object Oriented Programming with Java, WiSe 2023/2024
 * Problem: <a href="https://open.kattis.com/problems/howmanydigits">How Many Digits?</a>
 * @author Hai Long Mac
 *
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.35
 */
package Week3.Task4.L;

import java.util.Scanner;
import static java.lang.Math.log10;

public class HowManyDigit {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int number = sc.nextInt();
            if (number == 0 || number == 1) {
                System.out.println("1");
            } else {
                System.out.println((int) ((number * log10(number / Math.E) + log10(2 * Math.PI * number) / 2) + 1));
            }
        }
    }
}
