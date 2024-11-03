package Week2.F;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class GoodMorningggg {

    public static HashSet<Integer> values;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        values = new HashSet<Integer>();

        generate(1, 0);
        var arr = new ArrayList<>(values);
        Collections.sort(arr);

        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int k = in.nextInt();
            if (arr.contains(k))
                System.out.println(k);
            else {
                for (int j = 0; j < arr.size() - 1; j++) {
                    if (arr.get(j) < k && k < arr.get(j + 1)) {
                        if (k - arr.get(j) < arr.get(j + 1) - k)
                            System.out.println(arr.get(j));
                        else
                            System.out.println(arr.get(j + 1));
                        break;
                    }
                }
            }
        }
    }

    public static void generate(int digit, int number) {
        if (number > 200) return;

        if (digit == 1) {
            generate(2, number);
            generate(4, number);
            number = number * 10 + digit;
            if (number <= 200) values.add(number);
            generate(1, number);
            generate(2, number);
            generate(4, number);
        }

        if (digit == 2) {
            generate(3, number);
            generate(5, number);
            number = number * 10 + digit;
            if (number <= 200) values.add(number);
            generate(2, number);
            generate(3, number);
            generate(5, number);
        }

        if (digit == 3) {
            generate(6, number);
            number = number * 10 + digit;
            if (number <= 200) values.add(number);
            generate(3, number);
            generate(6, number);
        }

        if (digit == 4) {
            generate(5, number);
            generate(7, number);
            number = number * 10 + digit;
            if (number <= 200) values.add(number);
            generate(4, number);
            generate(5, number);
            generate(7, number);
        }

        if (digit == 5) {
            generate(6, number);
            generate(8, number);
            number = number * 10 + digit;
            if (number <= 200) values.add(number);
            generate(5, number);
            generate(6, number);
            generate(8, number);
        }

        if (digit == 6) {
            generate(9, number);
            number = number * 10 + digit;
            if (number <= 200) values.add(number);
            generate(6, number);
            generate(9, number);
        }

        if (digit == 7) {
            generate(8, number);
            number = number * 10 + digit;
            if (number <= 200) values.add(number);
            generate(7, number);
            generate(8, number);
        }

        if (digit == 8) {
            generate(9, number);
            generate(0, number);
            number = number * 10 + digit;
            if (number <= 200) values.add(number);
            generate(8, number);
            generate(9, number);
            generate(0, number);
        }

        if (digit == 9) {
            number = number * 10 + digit;
            if (number <= 200) values.add(number);
            generate(9, number);
        }

        if (digit == 0) {
            number = number * 10 + digit;
            if (number <= 200) values.add(number);
            if (number != 0) generate(0, number);
        }
    }
}

