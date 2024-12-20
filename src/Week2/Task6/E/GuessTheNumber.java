
/**
 * Advanced Object Oriented Programming with Java, WiSe 2023/2024
 * Problem: <a href="https://open.kattis.com/problems/guess">Guess the Number</a>
 * @author Hai Long Mac
 *
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.04
 */
package Week2.Task6.E;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class GuessTheNumber {
    public static void main(String[] args) throws IOException {
        int count = 0;
        int randomNumber = (int) (Math.random() * 1000) + 1;

        int low = 1;
        int high = 1000;


        BufferedReader readFromTerminal = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writeToTerminal = new PrintWriter(System.out, true);

        while (count<10) {
            int guessNumber = (high + low)/2;
                writeToTerminal.println(guessNumber);
                writeToTerminal.flush();

            String response = readFromTerminal.readLine().trim();

            if (response.equals("correct")) {
                break;
            }
             else if (response.equals("lower")) {
high = guessNumber -1;
             }
            if (response.equals("higher")) {
                low = guessNumber + 1;
            }

            count++;
        }

    }
}
