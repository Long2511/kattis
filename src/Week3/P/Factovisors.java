package Week3.P;

import java.util.Scanner;

public class Factovisors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line;

        while (sc.hasNextLine()) {
            line = sc.nextLine().trim();
            if (line.equals("")) continue;
            String[] tokens = line.split("\\s+");

            int n = Integer.parseInt(tokens[0]);
            long m = Long.parseLong(tokens[1]);

            if (m == 0) {
                System.out.println("Division by zero is undefined.");
                continue;
            }

            if (m == 1 || m <= n) {
                System.out.println(m + " divides " + n + "!");
                continue;
            }

            boolean divides = true;
            long M = m;
            long tempM = m;

            for (long i = 2; i * i <= tempM; i++) {
                int countM = 0;

                while (tempM % i == 0) {
                    tempM /= i;
                    countM++;
                }

                if (countM > 0) {
                    long countN = countPrimeInFactorial(n, i);
                    if (countN < countM) {
                        divides = false;
                        break;
                    }
                }
            }

            if (divides && tempM > 1) {
                if (tempM > n) {
                    divides = false;
                } else {
                    long countN = countPrimeInFactorial(n, tempM);
                    if (countN < 1) {
                        divides = false;
                    }
                }
            }

            if (divides) {
                System.out.println(M + " divides " + n + "!");
            } else {
                System.out.println(M + " does not divide " + n + "!");
            }
        }
    }

    private static long countPrimeInFactorial(int n, long p) {
        long count = 0;
        long divisor = p;
        while (divisor <= n) {
            count += n / divisor;
            divisor *= p;
        }
        return count;
    }
}