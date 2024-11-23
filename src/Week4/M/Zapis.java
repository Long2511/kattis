package Week4.M;

import java.util.*;

public class Zapis {
    public static long countValidSequences(int N, String s) {
        int mod = 100000;
        Map<Character, Character> matchingPairs = new HashMap<>();
        matchingPairs.put('(', ')');
        matchingPairs.put('[', ']');
        matchingPairs.put('{', '}');

        Set<Character> openingBrackets = matchingPairs.keySet();
        Set<Character> closingBrackets = new HashSet<>(matchingPairs.values());

        int n = s.length();
        long[][] dp = new long[n][n];
        boolean overflow = false;

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
                        long left = (i + 1 <= k - 1) ? dp[i + 1][k - 1] : 1;
                        long right = (k + 1 <= j) ? dp[k + 1][j] : 1;

                        long add =  (ways * left * right) % mod;
                        if (i == 0 && j == n - 1) {
                            if (ways * left * right > 100000) {
                                overflow = true;
                            }
                        }
                        dp[i][j] += add;
                        if (i == 0 && j == n - 1) {
                            if (dp[i][j] > 100000) {
                                overflow = true;
                            }
                        }
                        dp[i][j] %= mod;
                    }
                }
            }
        }
        if(overflow) {
            if(dp[0][n - 1] < 10) {
                System.out.print("0000");
            }
            else if(dp[0][n - 1] < 100) {
                System.out.print("000");
            }
            else if(dp[0][n - 1] < 1000) {
                System.out.print("00");
            }
            else if(dp[0][n - 1] < 10000) {
                System.out.print("0");
            }
        }
        return dp[0][n - 1] % mod;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine().trim();

        System.out.println(countValidSequences(N, s));
    }
}