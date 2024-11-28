/**
 * Advanced Object Oriented Programming with Java, WiSe 2023/2024
 * Problem: <a href="https://open.kattis.com/contests/v499w5/submissions/14756914">Bela</a>
 * @author Thanh Phuc Le
 *
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.10
 */

package Week1.Task6.I;

import java.util.Scanner;

public class Bela {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        char b = sc.next().charAt(0);
        char[] num ={'A','K','Q','J','T','9','8','7'};
        int[] domi = {11,4,3,20,10,14,0,0};
        int[] not_domi = {11,4,3,2,10,0,0,0};
        int sum = 0;

        for (int i=0;i<4*n;i++){
            String s = sc.next();
            int index = 0;
            for (int j=0;j<8;j++){
                if (s.charAt(0) == num[j]){
                    index = j;
                }
            }
            if (s.charAt(1) == b){
                sum = sum + domi[index];
            }
            else {
                sum = sum + not_domi[index];
            }
        }
        System.out.println(sum);
        sc.close();
    }
}
