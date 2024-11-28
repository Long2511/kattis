
/**
 * Advanced Object Oriented Programming with Java, WiSe 2023/2024
 * Problem: <a href="https://open.kattis.com/problems/4thought">4 thought</a>
 * @author Hai Long Mac
 *
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.16
 */
package Week4.Task6.E;

import java.util.Scanner;
import java.util.HashMap;

public class FourThought {

    // Return the operator string based on the input integer
    public static String op(int in) {
        return switch (in) {
            case 0 -> " * ";
            case 1 -> " + ";
            case 2 -> " - ";
            default -> " / ";
        };
    }

    // Build an expression string using the provided operator indices
    public static String build(int a, int b, int c) {
        return "4" + op(a) + "4" + op(b) + "4" + op(c) + "4";
    }

    // Evaluate a simple two-number arithmetic operation from a string
    public static int arith(String oper) {
        int num1 = Integer.parseInt(oper.substring(0, oper.indexOf(" ")));
        int num2 = Integer.parseInt(oper.substring(oper.lastIndexOf(" ") + 1));

        if (oper.contains(" * "))
            return num1 * num2;
        if (oper.contains(" + "))
            return num1 + num2;
        if (oper.contains(" - "))
            return num1 - num2;

        return num1 / num2; // Division case
    }

    // Evaluate a complete arithmetic expression string
    public static int eval(String input) {
        // Handle multiplication and division first
        while (input.contains(" * ") || input.contains(" / ")) {
            int mult = input.indexOf("*");
            int divi = input.indexOf("/");
            int sub1 = mult == -1 ? divi - 2 : mult - 2;
            int sub2 = mult == -1 ? divi + 2 : mult + 2;

            // Find the bounds of the current operation
            while (sub1 > 0 && !input.substring(sub1, sub1 + 1).equals(" ")) sub1--;
            if (sub1 != 0) sub1++;
            while (sub2 < input.length() && !input.substring(sub2, sub2 + 1).equals(" ")) sub2++;

            // Replace the evaluated part in the input string
            input = input.substring(0, sub1) + arith(input.substring(sub1, sub2)) + input.substring(sub2);
        }

        // Handle addition and subtraction next
        while (input.contains(" + ") || input.contains(" - ")) {
            int add = input.indexOf(" + ");
            int sub = input.indexOf(" - ");
            int sub1 = add == -1 ? sub - 1 : add - 1;
            int sub2 = add == -1 ? sub + 3 : add + 3;

            // Find the bounds of the current operation
            while (sub1 > 0 && !input.substring(sub1, sub1 + 1).equals(" ")) sub1--;
            if (sub1 != 0) sub1++;
            while (sub2 < input.length() && !input.substring(sub2, sub2 + 1).equals(" ")) sub2++;

            // Replace the evaluated part in the input string
            input = input.substring(0, sub1) + arith(input.substring(sub1, sub2)) + input.substring(sub2);
        }

        return Integer.parseInt(input);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashMap<Integer, String> map = new HashMap<>();
        int cases = scan.nextInt();

        // Precompute all possible expressions and store them in a map
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                for (int k = 0; k < 4; k++) {
                    String expression = build(i, j, k);
                    map.put(eval(expression), expression);
                }

        // Process each test case
        for (int i = 0; i < cases; i++) {
            int num = scan.nextInt();
            if (map.containsKey(num))
                System.out.println(map.get(num) + " = " + num);
            else
                System.out.println("no solution");
        }

        scan.close();
    }
}
