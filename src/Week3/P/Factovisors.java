package Week3.P;

import java.util.Scanner;

public class Factovisors {

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static boolean mDivideNFactorial(int n, int m) {
        if (m == 0) return false;

        for (int divisor = 2; divisor <= Math.sqrt(m); divisor++) {
            if (m % divisor != 0) continue;

            int power = 0;
            while (m % divisor == 0) {
                m /= divisor;
                power += 1;
            }

            int powerInNFactorial = 0;
            int powDivisor = 1;
            while (powDivisor <= n / divisor && powerInNFactorial < power) {
                powDivisor *= divisor;
                powerInNFactorial += n / powDivisor;
            }

            if (power > powerInNFactorial) {
                return false;
            }
        }

        if (m <= Math.max(1, n)) return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String[] data = input.split(" ");
            int n = Integer.valueOf(data[0]);
            int m = Integer.valueOf(data[1]);

            if (mDivideNFactorial(n, m)) {
                System.out.printf("%d divides %d!\n", m, n);
            } else {
                System.out.printf("%d does not divide %d!\n", m, n);
            }
        }

        scanner.close();
    }
}