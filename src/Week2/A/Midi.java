package Week2.A;

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
