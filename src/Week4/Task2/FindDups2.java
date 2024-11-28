package Week4.Task2;

import java.util.*;

public class FindDups2 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana");
        Set<String> uniqueWords = new HashSet<>();
        Set<String> duplicates = new HashSet<>();

        for (String word : words) {
            if (!uniqueWords.add(word)) {
                duplicates.add(word);
            }
        }

        System.out.println("Duplicate words: " + duplicates);
    }
}
