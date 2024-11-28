/**
 * Advanced Object Oriented Programming with Java, WiSe 2023/2024
 * Problem: <a href="https://open.kattis.com/contests/v499w5/submissions/14758174">HangMan</a>
 * @author Bao Ngoc Duong
 *
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.09
 */

package Week1.Task6.A;

import java.util.Scanner;

public class HangMan {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] arr = sc.next().toCharArray();
        int count = 0;
        for (int x = 0; x < arr.length; x++) {
            if (s.contains(arr[x] + ""))
                s = s.replace(arr[x] + "", "");
            else
                count++;
            if (s.isEmpty()) {
                System.out.println("WIN");
                return;
            } else if (count == 10) {
                System.out.println("LOSE");
                return;
            }
        }
    }
}
