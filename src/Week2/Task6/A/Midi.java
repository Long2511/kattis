
/**
 * Advanced Object Oriented Programming with Java, WiSe 2023/2024
 * Problem: <a href="https://open.kattis.com/problems/midi">Midi</a>
 * @author Hai Long Mac
 *
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 1.66
 */
package Week2.Task6.A;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Midi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine().trim());

        ArrayList<String> notes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            notes.add(scanner.nextLine().trim());
        }

        Collections.reverse(notes);

        for (int i = 0; i < notes.size(); i++) {
            String reversedNote = new StringBuilder(notes.get(i)).reverse().toString();
            notes.set(i, reversedNote);
        }

        StringBuilder encryptedMessage = new StringBuilder();
        for (String note : notes) {
            encryptedMessage.append(note);
        }

        String originalMessage = encryptedMessage.toString();

        System.out.println(originalMessage);

        scanner.close();
    }
}
