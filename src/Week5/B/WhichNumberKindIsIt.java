
/**
 * Advanced Object Oriented Programming with Java, WiSe 2023/2024
 * Problem: <a href="https://open.kattis.com/problems/whichnumberkindisit2">Which Number Kind Is It?</a>
 * @author Hai Long Mac
 *
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.95
 */

package Week5.B;

import java.util.Scanner;

public class WhichNumberKindIsIt {public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Read the number of test cases
    int t = scanner.nextInt();

    // Iterate over each test case
    for (int i = 0; i < t; i++) {
        int n = scanner.nextInt();
        boolean isOdd = (n % 2 != 0);
        boolean isSquare = (Math.sqrt(n) == (int) Math.sqrt(n));

        // Determine the kind of number
        if (isOdd && isSquare) {
            System.out.println("OS");
        } else if (isOdd) {
            System.out.println("O");
        } else if (isSquare) {
            System.out.println("S");
        } else {
            System.out.println("EMPTY");
        }
    }

    scanner.close();
}

}
