/**
 * Advanced Object Oriented Programming with Java, WiSe 2024/2025
 * Problem: Emoticons
 * Link: https://open.kattis.com/contests/p6fq6m/problems/emoticons2
 * @author Mac Hai Long
 * @version 1.0, 11/27/2024
 * Method : String process
 * Status : Accepted
 * Runtime: 0.24
 */

package Week5.D;

import java.util.Scanner;

public class Emoticons {
    final static String CHARACTER_SET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                                        "abcdefghijklmnopqrstuvwxyz" +
                                        "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ ";
    final static String[] emoji = {":)", ":-)", ":-(", ";-)", "xD", "^_^", "-_-", "^o^", "^^;", "(..)"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        int minLength = Integer.MAX_VALUE;
        int maxLength = Integer.MIN_VALUE;

        for (int oldCharIndex = 0; oldCharIndex < CHARACTER_SET.length(); oldCharIndex++) {
            for (int newCharIndex = 0; newCharIndex < CHARACTER_SET.length(); newCharIndex++) {
                int tempLength = getTempLength(text, oldCharIndex, newCharIndex);
                minLength = Math.min(minLength, tempLength);
                maxLength = Math.max(maxLength, tempLength);
            }
        }

        System.out.println(minLength + " " + maxLength);

        scanner.close();
    }

    private static int getTempLength(String text, int oldCharIndex, int newCharIndex) {
        String newText = text.replace(CHARACTER_SET.charAt(oldCharIndex), CHARACTER_SET.charAt(newCharIndex));
        int tempLength = 0;

        for (int i = 0; i < newText.length(); i++) {
            tempLength += 1;
            for (String s : emoji) {
                if (i + s.length() - 1 < newText.length()) {
                    if (newText.startsWith(s, i)) {
                        i += s.length() - 1;
                        break;
                    }
                }
            }
        }

        return tempLength;
    }
}
