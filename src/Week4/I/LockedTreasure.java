
/**
 * Advanced Object Oriented Programming with Java, WiSe 2023/2024
 * Problem: <a href="https://open.kattis.com/problems/lockedtreasure">Locked Treasure</a>
 * @author Hai Long Mac
 *
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.07
 */
package Week4.I;

import java.util.*;
import java.io.*;

public class LockedTreasure {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // Initialize the binomial coefficient array
        long[][] nCk = new long[32][32];

        // Set base case for binomial coefficients
        for (int i = 0; i < 31; i++) {
            nCk[i][1] = 1;
        }

        // Compute binomial coefficients using Pascal's triangle
        for (int i = 1; i < 32; i++) {
            for (int j = 1; j <= i; j++) {
                nCk[i][j] = nCk[i - 1][j - 1] + nCk[i - 1][j];
            }
        }

        // Read the number of test cases
        int c = Integer.parseInt(br.readLine());

        // Process each test case
        while (c-- > 0) {
            String[] strs = br.readLine().split(" ");
            if (strs[1].equals("1")) {
                // If the second number is 1, the result is always 1
                bw.write("1\n");
            } else {
                // Calculate the binomial coefficient for the given inputs
                bw.write(nCk[Integer.parseInt(strs[0]) + 1][Integer.parseInt(strs[1])] + "\n");
            }
        }

        // Flush the output buffer
        bw.flush();
    }
}