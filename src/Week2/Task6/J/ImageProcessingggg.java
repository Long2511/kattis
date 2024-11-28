
/**
 * Advanced Object Oriented Programming with Java, WiSe 2023/2024
 * Problem: <a href="https://open.kattis.com/problems/imageprocessing">Image Processing</a>
 * @author Hai Long Mac
 *
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.13
 */
package Week2.Task6.J;

import java.util.Scanner;

public class ImageProcessingggg {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int H = scanner.nextInt();
        int W = scanner.nextInt();
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int outputHeight = H - N + 1;
        int outputWidth = W - M + 1;
        int[][] result = new int[outputHeight][outputWidth];

        int[][] image = new int[H][W];
        int[][] filter = new int[N][M];


        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                image[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                filter[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < outputHeight; i++) {
            for (int j = 0; j < outputWidth; j++) {
                result[i][j] = applyFilter(image, filter, i, j, N, M);
            }
        }

        for (int i = 0; i < outputHeight; i++) {
            for (int j = 0; j < outputWidth; j++) {
                System.out.print(result[i][j]);
                if (j < outputWidth - 1) System.out.print(" ");
            }
            System.out.println();
        }

        scanner.close();
    }

    private static int applyFilter(int[][] image, int[][] filter, int startHorizontal, int startVertical, int filterHeight, int filterWidth) {
        int sum = 0;
        for (int i = 0; i < filterHeight; i++) {
            for (int j = 0; j < filterWidth; j++) {
                sum += image[startHorizontal + i][startVertical + j] * filter[filterHeight - 1 - i][filterWidth - 1 - j];
            }
        }
        return sum;
    }
}
