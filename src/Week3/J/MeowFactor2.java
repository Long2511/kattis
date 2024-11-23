
/**
 * Advanced Object Oriented Programming with Java, WiSe 2023/2024
 * Problem: <a href="https://open.kattis.com/problems/meowfactor2">Meow Factor 2</a>
 * @author Hai Long Mac
 *
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.77
 */
package Week3.J;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MeowFactor2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();

        String[] patterns = {
                "meow",
                "meo.?|me.?w|m.?ow|.?eow|meo.?w|me.?ow|m.?eow|moew|emow|mewo",
                "me.?.?|m.?o.?|m.?.?w|.?eo.?|.?e.?w|.?.?ow",
                "m.?.?.?|.?e.?.?|.?.?o.?|.?.?.?w",
                ""
        };

        for (int i = 0; i < patterns.length; i++) {
            Pattern pattern = Pattern.compile(patterns[i]);
            Matcher matcher = pattern.matcher(s);
            if (matcher.find()) {
                System.out.println(i);
                return;
            }
        }
    }
}