package Week1.Task5;

import java.util.Scanner;

public class StuckInATimeLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        for (int i = 1; i < count +1; i++){
            System.out.println(i + " Abracadabra");
        }
        scanner.close();
    }
}
