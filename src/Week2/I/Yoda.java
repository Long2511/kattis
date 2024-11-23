
/**
 * Advanced Object Oriented Programming with Java, WiSe 2023/2024
 * Problem: <a href="https://open.kattis.com/problems/yoda">Yoda</a>
 * @author Hai Long Mac
 *
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.09
 */
package Week2.I;

import java.util.Scanner;

public class Yoda {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        StringBuilder nRemaining = new StringBuilder();
        StringBuilder mRemaining = new StringBuilder();

        while (n > 0 || m > 0) {
            int nDigit = n % 10;
            int mDigit = m % 10;

            if (n > 0 && m > 0) {
                if (nDigit > mDigit) {
                    nRemaining.insert(0, nDigit);
                } else if (mDigit > nDigit) {
                    mRemaining.insert(0, mDigit);
                } else {
                    nRemaining.insert(0, nDigit);
                    mRemaining.insert(0, mDigit);
                }
            } else if (n > 0) {
                nRemaining.insert(0, nDigit);
            } else {
                mRemaining.insert(0, mDigit);
            }

            n /= 10;
            m /= 10;
        }

        CheckAndPrintResult(nRemaining);

        CheckAndPrintResult(mRemaining);

        scanner.close();
    }

    private static void CheckAndPrintResult(StringBuilder mRemaining) {
        if (mRemaining.isEmpty()) {
            System.out.println("YODA");
        } else {
            System.out.println(Integer.parseInt(mRemaining.toString()));
        }
    }
}
