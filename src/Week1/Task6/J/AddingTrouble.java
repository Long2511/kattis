package Week1.Task6.J;

import java.util.Scanner;

public class AddingTrouble {
    public static void main(String[] args) {
        int a, b, givenSolution = 0;

        Scanner scanner = new Scanner(System.in);

        a = scanner.nextInt();
        b = scanner.nextInt();

        int solution = a + b;

        if( givenSolution == solution){
            System.out.println("correct!");
    }
        else{

        System.out.println("wrong!");
        }
    }
}
