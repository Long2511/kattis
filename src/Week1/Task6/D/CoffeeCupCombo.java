/**
 * Advanced Object Oriented Programming with Java, WiSe 2023/2024
 * Problem: <a href="https://open.kattis.com/contests/v499w5/submissions/14748803">Coffee Cup Combo	</a>
 * @author Thanh Phuc Le
 *
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.16
 */

package Week1.Task6.D;

import java.util.Scanner;

public class CoffeeCupCombo {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int coffee = 0;
        int count = 0;
        
        int n = sc.nextInt();
        sc.nextLine();
        
        String s = sc.nextLine();
        
        for (int i=0;i<n;i++){
            if (s.charAt(i)=='1'){
                coffee = 3;
            }
            if (coffee > 0){
                coffee = coffee - 1;
                count = count + 1;
            }
        }
        System.out.println(count);
        
        sc.close();
    }
    
}