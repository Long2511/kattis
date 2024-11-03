package Week2.N;

import java.math.BigInteger;
import java.util.Scanner;

public class SimpleAddition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        String firstNumber = scanner.nextLine();
        String secondNumber = scanner.nextLine();

        BigInteger bigInteger1 = new BigInteger(firstNumber);
        BigInteger bigInteger2 = new BigInteger(secondNumber);

        BigInteger sum = bigInteger1.add(bigInteger2);


        System.out.println(sum);

    }

}
