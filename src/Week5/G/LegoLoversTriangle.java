
package Week5.G;

import java.util.Scanner;

public class LegoLoversTriangle {

    public static int calculateTotalBricks(int N, int M) {
        /*
         * dp[0][i] = maximum number of bricks that can be placed in rows [i, i+1, ..., N]
         * and the bricks on row i are not indented
         * dp[1][i] = maximum number of bricks that can be placed in rows [i, i+1, ..., N]
         * and the bricks on row i are indented
         */
        int[][] dp = new int[2][N + 1];
        for (int i = N - 1; i >= 0; i--) {

            // 75i / 75N = 112.5x / 112.5M => x = i * M / N

            double triangleLimit = (1.0 * i * M / N);
            // 0 -> not indented => number of bricks on layer i: floor(x / 2)
            dp[0][i] = dp[1][i + 1] + (int) Math.floor(triangleLimit / 2);
            // 1 -> indented => number of bricks on layer i: floor((x - 1) / 2)
            dp[1][i] = dp[0][i + 1] + Math.max(0, (int) Math.floor((triangleLimit - 1) / 2));

        }
        return Math.max(dp[0][0], dp[1][0]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.close();

        System.out.println(Math.max(calculateTotalBricks(N, M), calculateTotalBricks(M, N)));
    }
}
