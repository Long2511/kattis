/**
 * Advanced Object Oriented Programming with Java, WiSe 2023/2024
 * Problem: <a href="https://open.kattis.com/contests/v499w5/submissions/14740082">Broken Swords</a>
 * @author Hai Long Mac
 *
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 1.66
 */

package Week1.Task6.F;

import java.util.Scanner;

public class BrokenSwords {
    public static void main(String[] args) {
        int tb=0, lr=0, N, tb_left = 0, lr_left = 0, total_make = 0;

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        
        String[] array = new String[N];
        
        for (int i=0; i<N; i++){
            array[i] = sc.next();
        }
        for (int i=0; i<N; i++){
            if (array[i].charAt(0) == '0'){
                tb = tb + 1;
            }
            if (array[i].charAt(1) == '0'){
                tb = tb + 1;
            }
            if (array[i].charAt(2) == '0'){
                lr = lr + 1;
            }
            if (array[i].charAt(3) == '0'){
                lr = lr + 1;
            }
        }
        tb_left = tb % 2;
        tb = tb / 2;
        lr_left = lr % 2;
        lr = lr / 2;

        if (tb <= lr) {
            total_make = tb;
            lr_left = lr_left + (lr - total_make) * 2;
        }
        else {
            total_make = lr;
            tb_left = tb_left + (tb - total_make) * 2;
        }
        
        System.out.println(total_make + " " + tb_left + " " + lr_left);
        sc.close();
    }
    
}