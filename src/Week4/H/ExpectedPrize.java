package Week4.H;

import java.util.Scanner;

public class ExpectedPrize {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            // Read input values for n and t
            int n = sc.nextInt();
            double t = sc.nextDouble();

            // If n is zero, break out of the loop (as per input termination condition)
            if (n == 0) break;

            // Initialize the array to store the expected winnings at each step
            double[] w = new double[n + 1];

            // Base case: the amount won if we reach the final step `n`
            w[n] = 1 << n; // Equivalent to `2^n`, which is a large base prize if all steps are successful

            // Iterate backwards from step `n-1` to `0`
            for (int i = n - 1; i >= 0; i--) {
                // Calculate the threshold `cut` at this step
                double cut = (1 << i) / w[i + 1];

                // Determine the expected winnings at step `i`
                if (t < cut) {
                    // Case 1: When probability `t` is less than `cut`
                    // This calculates the expected prize based on staying or continuing
                    w[i] = ((cut - t) / (1 - t)) * (1 << i) + ((1 - cut) / (1 - t)) * ((cut + 1) / 2) * w[i + 1];
                } else {
                    // Case 2: When probability `t` is greater than or equal to `cut`
                    // The expected prize calculation if we continue
                    w[i] = ((1 + t) / 2) * w[i + 1];
                }
            }

            // Output the result rounded to three decimal places
            System.out.printf("%.3f%n", w[0]);
        }

        sc.close();
    }
}