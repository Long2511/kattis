package Week5.M;

import java.util.Scanner;

public class WelcomeSign {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int asyncRow = 0;

        sc.nextLine();

        for (int i = 1; i <= r; i++) {
            String word = sc.nextLine();
            int wordLength = word.length();
            int totalPadding = c - wordLength;
            int leftPadding = totalPadding / 2;
            int rightPadding = totalPadding - leftPadding;

            if (totalPadding % 2 != 0) {
                asyncRow++;
                // Total padding is odd, left and right padding cannot be equal
                // Apply row-specific padding rules only in this case
                if (asyncRow %2 == 1) { // Odd rows
                    // Left padding should be less than or equal to right padding
                    leftPadding = totalPadding / 2;

                } else { // Even rows
                    // Left padding should be greater than or equal to right padding
                    leftPadding = (totalPadding + 1) / 2;

                }
                rightPadding = totalPadding - leftPadding;

            }
            // Build the line
            String leftDots = repeatChar(leftPadding);
            String rightDots = repeatChar(rightPadding);
            String line = leftDots + word + rightDots;
            System.out.println(line);
        }
        sc.close();
    }

    private static String repeatChar(int times) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < times; j++) {
            sb.append('.');
        }
        return sb.toString();
    }
}
