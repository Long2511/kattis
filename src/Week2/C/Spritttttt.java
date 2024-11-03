package Week2.C;

import java.util.Scanner;

public class Spritttttt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfClass = scanner.nextInt();
        int numberOfHandSanitizerAvailable = scanner.nextInt();
        int numberOfHandSanitizerNeeded = 0;

        for (int i = 0; i < numberOfClass; i++) {
            numberOfHandSanitizerNeeded += scanner.nextInt();
        }

        if (numberOfHandSanitizerNeeded < numberOfHandSanitizerAvailable || numberOfHandSanitizerNeeded == numberOfHandSanitizerAvailable) {
            System.out.println("Jebb");
        }
        else {
            System.out.println("Neibb");
        }
    }
}
