
/**
 * Advanced Object Oriented Programming with Java, WiSe 2023/2024
 * Problem: <a href="https://open.kattis.com/problems/modulo">Modulo</a>
 * @author Hai Long Mac
 *
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.09
 */
package Week2.G;

import java.util.HashSet;
import java.util.Scanner;

public class Modulo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<Integer> remainders = new HashSet<>();

        for (int i = 0; i<10 ; i++) {
            int number = scanner.nextInt();
            int remainder = number % 42;
            remainders.add(remainder);

        }

        System.out.println(remainders.size());
    }
}
