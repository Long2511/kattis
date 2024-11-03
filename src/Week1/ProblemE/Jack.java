package Week1.ProblemE;

import java.util.Scanner;

public class Jack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N, T, M;

        while (true) {
            int input = scanner.nextInt();
            if (input >= 1 && input <= 500) {
                N = input;
                break;
            }
        }

        while (true) {
            int input = scanner.nextInt();
            if (input >= 1 && input <= 500) {
                T = input;
                break;
            }
        }

        while (true) {
            int input = scanner.nextInt();
            if (input >= 1 && input <= 500) {
                M = input;
                break;
            }
        }

        int totalDesign = N * T * M;
        System.out.println(totalDesign);

        scanner.close();
    }
}
