
/**
 * Advanced Object Oriented Programming with Java, WiSe 2023/2024
 * Problem: <a href="https://open.kattis.com/problems/honey">Honeycomb Walk</a>
 * @author Hai Long Mac
 *
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.09
 */
package Week4.F;

import java.util.Scanner;

public class HoneycombWalk {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt(); // Number of test cases
        int[] input = new int[N];

        // Read the input steps for each test case
        for (int n = 0; n < N; n++) {
            input[n] = in.nextInt();
        }

        // Find the maximum steps needed
        int max = findMax(input);
        int[][][] results = new int[2 * max + 1][2 * max + 1][max + 1];

        // Initialize starting position
        results[max][max][0] = 1;

        // Fill the DP table for each step
        for (int step = 1; step <= max; step++) {
            for (int x = 0; x < 2 * max + 1; x++) {
                for (int y = 0; y < 2 * max + 1; y++) {

                    // Update current cell based on neighbors
                    if (y > 0)
                        results[x][y][step] += results[x][y - 1][step - 1];

                    if (x > 0)
                        results[x][y][step] += results[x - 1][y][step - 1];

                    if (x > 0 && y > 0)
                        results[x][y][step] += results[x - 1][y - 1][step - 1];

                    if (x < 2 * max)
                        results[x][y][step] += results[x + 1][y][step - 1];

                    if (y < 2 * max)
                        results[x][y][step] += results[x][y + 1][step - 1];

                    if (x < 2 * max && y < 2 * max)
                        results[x][y][step] += results[x + 1][y + 1][step - 1];
                }
            }
        }

        // Print results for each input value
        for (int x : input) {
            System.out.println(results[max][max][x]);
        }

        in.close();
    }

    // Helper method to find the maximum value in an array
    private static int findMax(int[] input) {
        int max = 0;
        for (int value : input) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
}

