package Week4.M;

import java.util.Scanner;

import java.util.*;

public class Zapis
{
    public static int countValidSequences(int N, String s) {
        int mod = 100000;
        Map<Character, Character> matchingPairs = new HashMap<>();
        matchingPairs.put('(', ')');
        matchingPairs.put('[', ']');
        matchingPairs.put('{', '}');

        Set<Character> openingBrackets = matchingPairs.keySet();
        Set<Character> closingBrackets = new HashSet<>(matchingPairs.values());

        int n = s.length();
        int[][] dp = new int[n][n];

        // Base cases: dp[i][i - 1] = 1 (empty substring is valid)
        for (int i = 0; i < n; i++) {
            if (i - 1 >= 0) {
                dp[i][i - 1] = 1;
            }
        }

        // DP computation
        for (int length = 2; length <= n; length += 2) { // lengths must be even
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                dp[i][j] = 0;

                for (int k = i + 1; k <= j; k += 2) { // k must be odd to maintain even lengths
                    int ways = 0;

                    // Possible opening brackets at s[i]
                    Set<Character> possible_s_i = new HashSet<>();
                    if (s.charAt(i) == '?') {
                        possible_s_i.addAll(openingBrackets);
                    } else if (openingBrackets.contains(s.charAt(i))) {
                        possible_s_i.add(s.charAt(i));
                    } else {
                        continue; // s[i] is not an opening bracket
                    }

                    // Possible closing brackets at s[k]
                    Set<Character> possible_s_k = new HashSet<>();
                    if (s.charAt(k) == '?') {
                        possible_s_k.addAll(closingBrackets);
                    } else if (closingBrackets.contains(s.charAt(k))) {
                        possible_s_k.add(s.charAt(k));
                    } else {
                        continue; // s[k] is not a closing bracket
                    }

                    // Count ways s[i] and s[k] can be matched
                    for (char o : possible_s_i) {
                        if (matchingPairs.get(o) != null && possible_s_k.contains(matchingPairs.get(o))) {
                            ways++;
                        }
                    }

                    if (ways > 0) {
                        int left = (i + 1 <= k - 1) ? dp[i + 1][k - 1] : 1;
                        int right = (k + 1 <= j) ? dp[k + 1][j] : 1;
                        dp[i][j] += ways * left * right;
                        dp[i][j] %= mod;
                    }
                }
            }
        }

        return dp[0][n - 1] % mod;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        String s = scanner.nextLine().trim();
        System.out.println(countValidSequences(N, s));
    }
}
