package Week3.D;

import java.util.Scanner;

public class HarshadNumbers {
    public static int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static boolean isHarshad(int num) {
        return num % sumOfDigits(num) == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();

        while (!isHarshad((int) n)) {
            n++;
        }

        System.out.println(n);
        scanner.close();
    }
}
