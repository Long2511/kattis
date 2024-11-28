/**
 * Advanced Object Oriented Programming with Java, WiSe 2024/2025
 * Problem: Problem F - Guard Evaders
 * Link: https://open.kattis.com/contests/p6fq6m/problems/guardevaders
 * @author Mac Hai Long
 * @version 1.0, 11/25/2024

 * Method : Implementation
 * Status : Accepted
 * Runtime: 0.13
 */

package Week5.F;

import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class GuardEvaders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int g = scanner.nextInt();
        int p = scanner.nextInt();
        String s = scanner.next();
        scanner.close();

        int result = 1;
        
        Set<String> curentPossition = new HashSet<>();
        Set<String> nextPossition = new HashSet<>();
        curentPossition.add(s);

        for (int nPlayer = 0; nPlayer <= p; nPlayer++) {
            if (curentPossition.isEmpty()) {
                result = 0;
                break;
            }
            for (String state : curentPossition) {
                StringBuilder tempState = new StringBuilder(state);

                for (int i = 0; i < g - 1; i++) {  // the player go through the space between guards i and i+1
                    if ((state.charAt(i) == 'L' || state.charAt(i) == 'F') && 
                        (state.charAt(i + 1) == 'R' || state.charAt(i + 1) == 'F')) {
                        // guards change their directions
                        
                        tempState.setCharAt(i, 'R');
                        tempState.setCharAt(i + 1, 'L');
                        nextPossition.add(tempState.toString());

                        // reverse the change
                        tempState.setCharAt(i, state.charAt(i));
                        tempState.setCharAt(i + 1, state.charAt(i + 1));
                    }
                }
            }
            curentPossition = nextPossition;
            nextPossition = new HashSet<>();
        }
        System.out.println(result);
    }
}
