package Week5.E;

import java.util.Scanner;


public class AirfareGrants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of flights
        int n = scanner.nextInt();

        // Array to store flight prices
        int[] prices = new int[n];

        // Input all flight prices
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }

        // Find the cheapest and most expensive flight prices
        int minPrice = Integer.MAX_VALUE;
        int maxPrice = Integer.MIN_VALUE;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            }
            if (price > maxPrice) {
                maxPrice = price;
            }
        }

        // Calculate the reimbursement limit
        double reimbursementLimit = maxPrice / 2.0;

        // Calculate the actual reimbursement
        double reimbursement = Math.min(minPrice, reimbursementLimit);

        // Calculate the net cost
        int netCost = (int)(minPrice - reimbursement);

        // Output the result
        System.out.println(netCost);

        scanner.close();
    }
}
