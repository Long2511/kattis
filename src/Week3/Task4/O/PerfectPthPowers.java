
/**
 * Advanced Object Oriented Programming with Java, WiSe 2023/2024
 * Problem: <a href="https://open.kattis.com/problems/perfectpowers">Perfect Pth Powers</a>
 * @author Hai Long Mac
 *
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.11
 */
package Week3.Task4.O;

import java.util.Scanner;

public class PerfectPthPowers {

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static int getPinPerfectPower(int number) {
        if (number == Integer.MIN_VALUE) {
            return 31;
        }

        boolean negative = false;
        if (number < 0) {
            negative = true;
            number = -number;
        }

        int result = -1;
        for (int divisor = 2; divisor <= Math.sqrt(number); divisor++) {
            if (number % divisor != 0) continue;
            int power = 0;
            while (number % divisor == 0) {
                number /= divisor;
                power += 1;
            }
            if (result == -1) {
                result = power;
            } else {
                result = gcd(result, power);
            }
        }
        if (number > 1) {
            result = 1;
        }
        if (negative) {
            while (result % 2 == 0) {
                result /= 2;
            }
        }
        if (result == -1) {
            result = 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number;
        while ((number = scanner.nextInt()) != 0) {
            System.out.println(getPinPerfectPower(number));
        }

        scanner.close();
    }
}