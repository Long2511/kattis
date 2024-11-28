/**
 * Advanced Object Oriented Programming with Java, WiSe 2023/2024
 * Problem: <a href="https://open.kattis.com/contests/v499w5/submissions/14757467">T9 Spelling</a>
 * @author Quynh Huyng Thi Kim
 *
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.53
 */

package Week1.Task6.L;

import java.util.HashMap;
import java.util.Scanner;

public class T9Spelling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashMap<Character, Integer> key = new HashMap<>();
        key.put('a', 2);
        key.put('b', 22);
        key.put('c', 222);
        key.put('d', 3);
        key.put('e', 33);
        key.put('f', 333);
        key.put('g', 4);
        key.put('h', 44);
        key.put('i', 444);
        key.put('j', 5);
        key.put('k', 55);
        key.put('l', 555);
        key.put('m', 6);
        key.put('n', 66);
        key.put('o', 666);
        key.put('p', 7);
        key.put('q', 77);
        key.put('r', 777);
        key.put('s', 7777);
        key.put('t', 8);
        key.put('u', 88);
        key.put('v', 888);
        key.put('w', 9);
        key.put('x', 99);
        key.put('y', 999);
        key.put('z', 9999);
        key.put(' ', 0);
        int p=scan.nextInt();
        scan.nextLine();
        for (int q = 1; q <= p; q++) {


            String b=scan.nextLine();

            char c[]= b.toCharArray();
            String d;
            char e;
            int y=0;
            int w;
            System.out.print("Case #" + q+ ": ");
            for (int i = 0; i < c.length; i++) {
                d= String.valueOf(key.get(c[i]));
                e= d.charAt(0);
                w = (int) e;
                if (w==y) {
                    System.out.print(" ");
                }

                System.out.print(key.get(c[i]));
                d= String.valueOf(key.get(c[i]));
                e= d.charAt(0);
                y = (int) e;

            }


            System.out.println("");
        }
    }
}
