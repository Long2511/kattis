package Week4.Task4;

import java.io.*;
import java.util.Random;

public class MixUpLetters {public static void main(String[] args) {
    // Input and output file paths
    String inputFile = "src/Week4/Exercises/text.in";
    String outputFile = "src/Week4/Exercises/text.out";

    // Read input file and process it
    try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
         BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

        String line;
        // Read each line from the input file
        while ((line = reader.readLine()) != null) {
            String scrambledLine = scrambleWords(line);
            writer.write(scrambledLine);
            writer.newLine();
        }

        System.out.println("File processed successfully and written to " + outputFile);

    } catch (IOException e) {
        e.printStackTrace();
    }
}

    /**
     * Scramble the letters inside words while keeping the first and last letter intact.
     *
     * @param line the line of text to be processed
     * @return the line with scrambled words
     */
    public static String scrambleWords(String line) {
        String[] words = line.split(" "); // Split the line into words
        StringBuilder scrambledLine = new StringBuilder();

        for (String word : words) {
            if (word.length() > 3) {
                // If the word length is greater than 3, scramble the inner letters
                String scrambledWord = scrambleWord(word);
                scrambledLine.append(scrambledWord).append(" ");
            } else {
                // Otherwise, keep the word unchanged
                scrambledLine.append(word).append(" ");
            }
        }

        // Remove the last space and return the scrambled line
        return scrambledLine.toString().trim();
    }

    /**
     * Scramble the letters inside a word while keeping the first and last letter intact.
     *
     * @param word the word to be scrambled
     * @return the scrambled word
     */
    public static String scrambleWord(String word) {
        // Get the first and last letters
        char firstLetter = word.charAt(0);
        char lastLetter = word.charAt(word.length() - 1);

        // If the word is just two characters, no scrambling is needed
        if (word.length() == 2) {
            return word;
        }

        // Get the middle part of the word
        String middle = word.substring(1, word.length() - 1);

        // Convert the middle part to a char array
        char[] middleArray = middle.toCharArray();

        // Shuffle the middle part
        Random rand = new Random();
        for (int i = 0; i < middleArray.length; i++) {
            int j = rand.nextInt(middleArray.length);
            // Swap characters
            char temp = middleArray[i];
            middleArray[i] = middleArray[j];
            middleArray[j] = temp;
        }

        // Reassemble the word with the first and last letters intact
        return firstLetter + new String(middleArray) + lastLetter;
    }
}
