
/**
 * Advanced Object Oriented Programming with Java, WiSe 2023/2024
 * Problem: <a href="https://open.kattis.com/problems/exam">Exam</a>
 * @author Hai Long Mac
 *
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.09
 */
package Week4.G;

import java.util.Scanner;

public class Exam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();  // Number of correct answers on friend's exam
        sc.nextLine();  // Consume newline
        String yourAnswers = sc.nextLine();  // Your answers
        String friendAnswers = sc.nextLine();  // Friend's answers

        int n = yourAnswers.length();
        int matches = 0;
        int mismatches = 0;

        // Count matches and mismatches between your answers and friend's answers
        for (int i = 0; i < n; i++) {
            if (yourAnswers.charAt(i) == friendAnswers.charAt(i)) {
                matches++;
            } else {
                mismatches++;
            }
        }

        // Calculate maximum possible correct answers
        int maxCorrect = Math.min(k, matches) + Math.min(n - k, mismatches);

        System.out.println(maxCorrect);

        sc.close();
    }
}
