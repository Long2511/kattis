import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class OOps {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        // Read input lines until there is no more input (EOF)
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.equals("")) continue; // Skip empty lines
            String[] tokens = line.split("\\s+");
            int n = Integer.parseInt(tokens[0]);     // N in the problem
            long m = Long.parseLong(tokens[1]);      // M in the problem

            if (m == 0) {
                System.out.println(m + " does not divide " + n + "!");
                continue;
            }

            if (m == 1 || m <= n) {
                System.out.println(m + " divides " + n + "!");
                continue;
            }

            boolean divides = true;
            long M = m;      // Preserve the original value of M
            long tempM = m;  // Temporary variable for factorization

            // Factorize M and check if each prime factor's exponent in M
            // is less than or equal to its exponent in N!
            for (long i = 2; i * i <= tempM; i++) {
                int countM = 0;

                // Count the exponent of prime factor i in M
                while (tempM % i == 0) {
                    tempM /= i;
                    countM++;
                }

                if (countM > 0) {
                    // Calculate the exponent of prime i in N!
                    long countN = countPrimeInFactorial(n, i);

                    // If exponent in N! is less than in M, M does not divide N!
                    if (countN < countM) {
                        divides = false;
                        break;
                    }
                }
            }

            // If tempM > 1, it means M has a prime factor greater than sqrt(M)
            if (divides && tempM > 1) {
                if (tempM > n) {
                    // If the remaining prime factor is greater than N, it cannot divide N!
                    divides = false;
                } else {
                    // Check the exponent of the remaining prime factor in N!
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

    // Function to count the exponent of prime p in N!
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
