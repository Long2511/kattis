package Week3.M;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ofugsnuio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();

        ArrayList<Integer> input = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            input.add(sc.nextInt());
        }

        Collections.reverse(input);

        for (int i = 0; i < size; i++) {
            System.out.println(input.get(i));
        }
    }
}
