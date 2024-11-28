package Week4.Task1;

import java.text.*;

public class DecimalFormatDemo {
    public static void main(String[] args) {
        double number = 123456.789;

        DecimalFormat df = new DecimalFormat("#,###.00");
        System.out.println("Formatted number: " + df.format(number));

        DecimalFormat df2 = new DecimalFormat("0.00%");
        System.out.println("Formatted as percentage: " + df2.format(0.789));
    }
}
