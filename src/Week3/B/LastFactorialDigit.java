package Week3.B;

import java.util.Scanner;

public class LastFactorialDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            if (N >= 5) {
                System.out.println(0);
            } else {
                int factorial = 1;
                for (int j = 1; j <= N; j++) {
                    factorial *= j;
                }
                System.out.println(factorial % 10);
            }
        }

        scanner.close();
    }
}