
/**
 * Advanced Object Oriented Programming with Java, WiSe 2023/2024
 * Problem: <a href="https://open.kattis.com/problems/almostperfect">Almost Perfect</a>
 * @author Hai Long Mac
 *
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.17
 */
package Week3.Task4.E;

import java.util.Scanner;

public class AlmostPerfect {
    public static long sumOfProperDivisors(long num) {
        long sum = 1;
        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i;
                if (i != num / i) {
                    sum += num / i;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLong()) {
            long p = scanner.nextLong();
            long sum = sumOfProperDivisors(p);

            if (sum == p) {
                System.out.println(p + " perfect");
            } else if (Math.abs(sum - p) <= 2) {
                System.out.println(p + " almost perfect");
            } else {
                System.out.println(p + " not perfect");
            }
        }
        scanner.close();
    }
}
