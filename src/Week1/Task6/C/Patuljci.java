/**
 * Advanced Object Oriented Programming with Java, WiSe 2023/2024
 * Problem: <a href="https://open.kattis.com/contests/v499w5/submissions/14744502">Patuljci</a>
 * @author Thanh Phuc Le
 *
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.09
 */

package Week1.Task6.C;

import java.util.Scanner;

public class Patuljci {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int sum = 0;
        int a = 0;
        int b = 0;
        int[] drw = new int[9];
        
        for (int i=0; i<9; i++){
            drw[i] = sc.nextInt();
            sum = sum + drw[i];
        }
        int req = sum - 100;
        
        for (int i=0;i<8;i++){
            for (int j=i+1;j<9;j++){
                if (drw[i] + drw[j] == req){
                    a = drw[i];
                    b = drw[j];
                } 
            }
        }
        for (int i=0; i<9;i++){
            if (drw[i] != a && drw[i] != b){
                System.out.println(drw[i]);
            }
        }
        
        sc.close();
    }
}