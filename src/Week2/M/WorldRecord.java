package Week2.M;

import java.util.Scanner;

public class WorldRecord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numerOfHighJump;
        long current;
        long previous;

        numerOfHighJump = sc.nextInt();
        current = sc.nextLong();
        previous = sc.nextLong();

        int count = 0;

        for (int i = 0; i < numerOfHighJump; i++) {
            long height = sc.nextLong();
            if (height > current + previous) {
                previous = current;
                current = height;
                count++;
            }
        }

        System.out.println(count);
    }
}
