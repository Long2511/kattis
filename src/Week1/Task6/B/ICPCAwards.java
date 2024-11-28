/**
 * Advanced Object Oriented Programming with Java, WiSe 2023/2024
 * Problem: <a href="https://open.kattis.com/contests/v499w5/submissions/14742334">ICPCAwards</a>
 * @author Thanh Phuc Le
 *
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 1.66
 */

package Week1.Task6.B;

import java.util.HashSet;
import java.util.Scanner;

public class ICPCAwards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<String> uni = new HashSet<String>();
        int n = sc.nextInt();
        int count = 0;

        for (int i = 0; i < n; i++){
            String a = sc.next();
            String b = sc.next();

            if (!uni.contains(a)){
                uni.add(a);
                System.out.println(a + " " + b);
                count++;
            }
            if (count ==  12){
                break;
            }
        }

        sc.close();
    }
}
