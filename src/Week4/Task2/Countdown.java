package Week4.Task2;

import java.util.*;

public class Countdown {
    public static void main(String[] args) {
        List<Integer> countdown = new ArrayList<>(Arrays.asList(5, 4, 3, 2, 1));

        for (Integer integer : countdown) {
            System.out.println(integer);
        }
    }
}