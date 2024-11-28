
/**
 * Advanced Object Oriented Programming with Java, WiSe 2023/2024
 * Problem: <a href="https://open.kattis.com/problems/geppetto">Geppetto</a>
 * @author Hai Long Mac
 *
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.64
 */
package Week4.Task6.D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;

public class Geppetto {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<Pair> v = new HashSet<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int t1 = Integer.parseInt(st.nextToken());
            int t2 = Integer.parseInt(st.nextToken());
            if (t1 > t2) {
                int temp = t1;
                t1 = t2;
                t2 = temp;
            }
            v.add(new Pair(t1, t2));
        }

        int ans = 0;
        for (int i = 0; i < (1 << n); i++) {
            if (works(v, i)) {
                ans++;
            }
        }

        System.out.println(ans);
    }

    static boolean works(Set<Pair> s, int n) {
        Set<Integer> in = new HashSet<>();
        int i = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                in.add(i);
            }
            i++;
            n >>= 1;
        }

        for (Pair p : s) {
            if (in.contains(p.first) && in.contains(p.second)) {
                return false;
            }
        }

        return true;
    }

    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return first == pair.first && second == pair.second;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }
}