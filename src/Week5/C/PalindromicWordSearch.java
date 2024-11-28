/**
 * Advanced Object Oriented Programming with Java, WiSe 2024/2025
 * Problem: Palindromic Word Search
 * Link: https://open.kattis.com/contests/p6fq6m/problems/palindromicwordsearch
 * @author Mac Hai Long
 * @version 1.0, 11/27/2024
 * Status : Accepted
 * Runtime: 4.70
 */

package Week5.C;

import java.util.Scanner;

public class PalindromicWordSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        char[][] charGrid = new char[N][M];

        for (int i = 0; i < N; i++) {
            String row = scanner.next();
            for (int j = 0; j < M; j++) {
                charGrid[i][j] = row.charAt(j);
            }
        }

        scanner.close();
    
        /*
         * rowPalindrome[i][j][k] = 1 if the substring (i, j), (i, j + 1), ..., (i, k) is a palindrome
         * colPalindrome[i][j][k] = 1 if the substring (i, j), (i + 1, j), ..., (k, j) is a palindrome
         */
        boolean[][][] rowPalindrome = new boolean[N][M][M];
        boolean[][][] colPalindrome = new boolean[N][M][N];

        /*
         * rowMaxLength[i][j] = maximum length of a palindrome that starts at (i, j) and goes to the right
         * colMaxLength[i][j] = maximum length of a palindrome that starts at (i, j) and goes down
         */
        int[][] rowMaxLength = new int[N][M];
        int[][] colMaxLength = new int[N][M];
        
        // Base cases for odd length palindromes (n = 1)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                rowPalindrome[i][j][j] = true;
                colPalindrome[i][j][i] = true;
                rowMaxLength[i][j] = 1;
                colMaxLength[i][j] = 1;
            }
        }

        // Base cases for even length palindromes (n = 2)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (j + 1 < M && charGrid[i][j] == charGrid[i][j + 1]) {
                    rowPalindrome[i][j][j + 1] = true;
                    rowMaxLength[i][j] = 2;
                }
                if (i + 1 < N && charGrid[i][j] == charGrid[i + 1][j]) {
                    colPalindrome[i][j][i + 1] = true;
                    colMaxLength[i][j] = 2;
                }
            }
        }

        // Calculate the rest of the values
        for (int length = 3; length <= Math.max(N, M); length++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (j + length - 1 < M && charGrid[i][j] == charGrid[i][j + length - 1] && rowPalindrome[i][j + 1][j + length - 2]) {
                        rowPalindrome[i][j][j + length - 1] = true;
                        rowMaxLength[i][j] = length;
                    }
                    if (i + length - 1 < N && charGrid[i][j] == charGrid[i + length - 1][j] && colPalindrome[i + 1][j][i + length - 2]) {
                        colPalindrome[i][j][i + length - 1] = true;
                        colMaxLength[i][j] = length;
                    }
                }
            }
        }


        /*
         * maxLenPassRow[i][j] = maximum length of a palindrome that passes through (i, j) horizontally
         * maxLenPassCol[i][j] = maximum length of a palindrome that passes through (i, j) vertically
         */
        int[][] maxLenPassRow = new int[N][M];
        int[][] maxLenPassCol = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = j; k < j + rowMaxLength[i][j]; k++) {
                    maxLenPassRow[i][k] = Math.max(maxLenPassRow[i][k], rowMaxLength[i][j]);
                }
                for (int k = i; k < i + colMaxLength[i][j]; k++) {
                    maxLenPassCol[k][j] = Math.max(maxLenPassCol[k][j], colMaxLength[i][j]);
                }
            }
        }

        int maxArea = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                maxArea = Math.max(maxArea, maxLenPassRow[i][j] * maxLenPassCol[i][j]);
            }
        }

        System.out.println(maxArea);
    }
}
