
/**
 * Advanced Object Oriented Programming with Java, WiSe 2023/2024
 * Problem: <a href="https://open.kattis.com/problems/ordinaryordinals">Ordinary Ordinals</a>
 * @author Hai Long Mac
 *
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.09
 */
package Week4.P;

import java.util.Scanner;

public class OrdinaryOrdinals {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long N = scanner.nextLong();
        long M = scanner.nextLong();
        scanner.close();

        long result = CalculateSomeThing(N, M);
        System.out.println(result);
    }

    static long CalculateSomeThing(long n, long m) {
        if (n == 0) {
            return 2 % m;
        }

        long result;

        //5 * pow(2, n - 1) - 1)
        result = CalculatePowerOfN(n - 1, m);
        result = (result*5) % m;
        result = (result - 1 + m) % m;

        return  result;
    }

    static long CalculatePowerOfN(long n, long m) {
        long result = 1;
        long base = 2;


        while (n > 0) {
            if ((n & 1) == 1) {
                result *= base;
                result = result % m;
            }
            base *= base;
            base = base % m;
            n >>= 1;
        }

        return result;
    }
}
