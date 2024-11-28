package Week1.Task5;

import java.util.Scanner;

public class Ladder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int height = scan.nextInt();
        int angle  = scan.nextInt();

        System.out.println((int)(Math.ceil(1 / (Math.sin(angle * (Math.PI / 180)) / height))));

        scan.close();
    }
}
