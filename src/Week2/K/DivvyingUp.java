package Week2.K;

import java.util.Scanner;

public class DivvyingUp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int totalPrize = 0;
        String[] prices = scanner.nextLine().split(" ");

        for (int i = 0; i < prices.length; i++) {
            totalPrize += Integer.parseInt(prices[i]);
        }


        if(totalPrize % 3 == 0) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}