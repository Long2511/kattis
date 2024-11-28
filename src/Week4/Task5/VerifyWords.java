package Week4.Task5;

import java.util.Arrays;
import java.io.*;

public class VerifyWords {
    public static void main(String[] args) {
        // Input file names
        String file1 = "src/Week4/Exercises/text.in";
        String file2 =  "src/Week4/Exercises/text.out";

        // Read and compare the files
        try {
            // Read the content of both files
            String text1 = readFile(file1);
            String text2 = readFile(file2);

            // Verify if the two texts match with scrambled words
            if (compareTexts(text1, text2)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to read a file into a String
    public static String readFile(String filename) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString().trim();
    }

    // Method to compare two texts
    public static boolean compareTexts(String text1, String text2) {
        String[] lines1 = text1.split("\n");
        String[] lines2 = text2.split("\n");

        // Check if the number of lines are the same
        if (lines1.length != lines2.length) {
            return false;
        }

        // Compare each line in both texts
        for (int i = 0; i < lines1.length; i++) {
            String line1 = lines1[i];
            String line2 = lines2[i];

            // Split each line into words
            String[] words1 = line1.split(" ");
            String[] words2 = line2.split(" ");

            // If the number of words are different, return false
            if (words1.length != words2.length) {
                return false;
            }

            // Compare each word
            for (int j = 0; j < words1.length; j++) {
                if (!compareWords(words1[j], words2[j])) {
                    return false;
                }
            }
        }

        return true; // If all lines and words match
    }

    // Method to compare two words considering the scrambling rule
    public static boolean compareWords(String word1, String word2) {
        // Check if the first and last letters match
        if (word1.length() > 1 && word2.length() > 1) {
            if (word1.charAt(0) != word2.charAt(0) || word1.charAt(word1.length() - 1) != word2.charAt(word2.length() - 1)) {
                return false;
            }

            // Scramble the middle part of the words and compare
            String middle1 = word1.substring(1, word1.length() - 1);
            String middle2 = word2.substring(1, word2.length() - 1);

            // If the middle parts are the same after sorting, the words are equivalent
            return sortedString(middle1).equals(sortedString(middle2));
        }

        // For single-letter or two-letter words, just compare directly
        return word1.equals(word2);
    }

    // Method to return the sorted string of a word
    public static String sortedString(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
