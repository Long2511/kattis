package Week2.M;

import java.util.Scanner;

public class WorldRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read inputs
        int n = scanner.nextInt(); // number of jumps
        int currentRecord = scanner.nextInt(); // current off-world record height
        int previousRecord = scanner.nextInt(); // previous record height (not used in calculations)

        int newRecords = 0;

        // Process each jump height
        for (int i = 0; i < n; i++) {
            int jumpHeight = scanner.nextInt();
            if (jumpHeight > currentRecord) {
                currentRecord = jumpHeight;
                newRecords++;
            }
        }

        // Output the number of new records set
        System.out.println(newRecords);

        scanner.close();
    }
}
