
/**
 * Advanced Object Oriented Programming with Java, WiSe 2023/2024
 * Problem: <a href="https://open.kattis.com/problems/catalan">Catalan Numbers</a>
 * @author Hai Long Mac
 *
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.63
 */
    package Week4.K;

    import java.math.BigInteger;
    import java.util.HashMap;
    import java.util.Scanner;

    public class CatalanNumbers {
        // HashMap to store precomputed Catalan numbers
        private static final HashMap<Integer, BigInteger> catalanMap = new HashMap<>();

        // Static block to initialize base cases
        static {
            catalanMap.put(0, BigInteger.ONE);
            catalanMap.put(1, BigInteger.ONE);
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            // Read the number of queries
            int q = sc.nextInt();
            for (int i = 0; i < q; i++) {
                // Read each query and print the corresponding Catalan number
                int n = sc.nextInt();
                System.out.println(catalan(n));
            }
            sc.close();
        }

        // Method to compute the Catalan number for a given n
        public static BigInteger catalan(int n) {
            // Check if the result is already computed
            if (catalanMap.containsKey(n)) {
                return catalanMap.get(n);
            }
            // Compute the Catalan number using the recursive formula
            if (n <= 500) {
                catalanMap.put(n, BigInteger.valueOf(((long) n << 2) - 2).multiply(catalan(n - 1)).divide(BigInteger.valueOf(n + 1)));
            } else {
                // Ensure the smaller Catalan numbers are computed first
                catalan(n - 500);
                catalanMap.put(n, BigInteger.valueOf(((long) n << 2) - 2).multiply(catalan(n - 1)).divide(BigInteger.valueOf(n + 1)));
            }
            return catalanMap.get(n);
        }
    }