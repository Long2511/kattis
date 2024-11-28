package Week4.Task2;

import java.util.*;

public class Shuffle {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("Apple", "Banana", "Orange", "Grape"));
        System.out.println("Before shuffle: " + list);
        Collections.shuffle(list);
        System.out.println("After shuffle: " + list);
    }
}
