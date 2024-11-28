/**
 * Advanced Object Oriented Programming with Java, WiSe 2024/2025
 * Problem: Leapfrog Encryption
 * Link: https://open.kattis.com/contests/p6fq6m/problems/leapfrogencryption
 * @author Mac Hai Long
 * @version 1.0, 11/27/2024
 * Method : Implementation
 * Status : Accepted
 * Runtime: 0.38
 */

package Week5.I;

import java.util.*;

public class LeapFrogEncryption {
    // Helper method to preprocess plaintext (retain lowercase letters only)
    private static String preprocessText(String text) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                result.append(c);
            }
        }
        return result.toString();
    }

    // Helper method to convert key to numeric shifts
    private static int[] keyToShifts(String key) {
        int[] shifts = new int[key.length()];
        for (int i = 0; i < key.length(); i++) {
            shifts[i] = key.charAt(i) - 'a' + 2;
        }
        return shifts;
    }

    public static String encrypt(String key, String plaintext) {
        String filteredText = preprocessText(plaintext);
        int[] keyShifts = keyToShifts(key);
        int n = filteredText.length();
        char[] ciphertext = new char[n];
        Arrays.fill(ciphertext, '\0'); // Initialize with null characters
        boolean direction = true; // True for left-to-right, False for right-to-left
        int currentIndex = 0;

        for (int shift : keyShifts) {
            int pos = direction ? 0 : n - 1;
            while (currentIndex < filteredText.length()) {
                // Find the next valid position
                for (int i = 1; i <= shift; i++) {
                    while (pos >= 0 && pos < n && ciphertext[pos] != '\0') {  // Skip filled positions
                        pos += direction ? 1 : -1;
                    }
                    if (pos < 0 || pos >= n) break;
                    if (i == shift) {
                        // Place the character
                        ciphertext[pos] = filteredText.charAt(currentIndex++);
                    }
                    // Shift to the next position
                    pos += direction ? 1 : -1;
                }
                if (pos < 0 || pos >= n) break;
            }
            // Alternate direction
            direction = !direction;
            if (currentIndex == filteredText.length()) {
                break;
            }
        }

        // Fill remaining positions
        for (int i = direction ? 0 : n - 1; i >= 0 && i < n; i += direction ? 1 : -1) {
            if (ciphertext[i] == '\0') {
                ciphertext[i] = filteredText.charAt(currentIndex++);
            }
        }

        return new String(ciphertext);
    }

    public static String decrypt(String key, String ciphertext) {
        int[] keyShifts = keyToShifts(key);
        int n = ciphertext.length();
        char[] plaintext = new char[n];
        boolean direction = true; // Start with left-to-right
        List<Integer> positionsOrder = new ArrayList<>();

        // Reconstruct the order of positions used during encryption
        for (int shift : keyShifts) {
            List<Integer> tempPositions = new ArrayList<>();
            int position = direction ? 0 : n - 1;
            while (true) {
                // Find the next valid position
                for (int i = 1; i <= shift; i++) {
                    while (position >= 0 && position < n && positionsOrder.contains(position)) {
                        // Skip filled positions
                        position += direction ? 1 : -1;
                    }
                    if (position < 0 || position >= n) break;
                    if (i == shift) {
                        // Add the position
                        tempPositions.add(position);
                    }
                    // Shift to the next position
                    position += direction ? 1 : -1;
                }
                if (position < 0 || position >= n) break;
            }

            positionsOrder.addAll(tempPositions);
            direction = !direction;
            if (positionsOrder.size() == n) {
                break;
            }
        }

        // Fill remaining positions
        if (positionsOrder.size() < n) {
            for (int i = direction ? 0 : n - 1; i >= 0 && i < n; i += direction ? 1 : -1) {
                if (!positionsOrder.contains(i)) {
                    positionsOrder.add(i);
                }
            }
        }

        // Reconstruct the plaintext from the positions order
        for (int i = 0; i < n; i++) {
            plaintext[i] = ciphertext.charAt(positionsOrder.get(i));
        }

        return new String(plaintext);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input mode and key
        String mode = scanner.next();
        String key = scanner.next();

        // Input text
        scanner.nextLine(); // Consume the newline
        String text = scanner.nextLine();

        if (mode.equals("E")) {
            System.out.println(encrypt(key, text));
        } else if (mode.equals("D")) {
            System.out.println(decrypt(key, text));
        }

        scanner.close();
    }
}
