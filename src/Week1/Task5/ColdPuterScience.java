package Week1.Task5;

import java.util.Scanner;

public class ColdPuterScience {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int coldTempCounts = 0;
        int n = scan.nextInt();
        for (int i = 1; i <= n; i++) {
            int b = scan.nextInt();
            if (b < 0) {
                coldTempCounts = coldTempCounts + 1;

            }
        }
        System.out.println(coldTempCounts);

    }
}

