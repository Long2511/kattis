package Week4.Task1;

import java.text.*;

public class TestFormat {
    public static void main(String[] args) {
        double number = 123456.789;

        // Format number with commas
        NumberFormat nf = NumberFormat.getInstance();
        System.out.println("Formatted number: " + nf.format(number));

        // Format number as currency
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        System.out.println("Formatted currency: " + currencyFormat.format(number));
    }
}
