package Week4.Task2;

import java.util.*;

public class Freq {
    public static void main(String[] args) {
        List<String> items = Arrays.asList("apple", "banana", "apple", "orange", "banana", "banana","apple", "banana", "apple", "orange", "banana", "banana");
        Map<String, Integer> freqMap = new HashMap<>();

        for (String item : items) {
            freqMap.put(item, freqMap.getOrDefault(item, 0) + 1);
        }

        System.out.println("Frequency of each item: " + freqMap);
    }
}