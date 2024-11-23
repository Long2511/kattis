package Week4.L;

import java.util.*;

public class PrimeSpiral {
    // Constant representing infinity
    static final int INF = Integer.MAX_VALUE;
    // Arrays to represent the four possible directions (up, down, left, right)
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};

    // Function to check if a number is prime
    public static boolean isPrime(int n) {
        if (n <= 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int currx = 0;
        int curry = 0;

        // Map to store the number corresponding to each coordinate
        Map<Pair<Integer, Integer>, Integer> toNum = new HashMap<>();
        // List to store the coordinates corresponding to each number
        List<Pair<Integer, Integer>> toCoord = new ArrayList<>(Collections.nCopies(10001, new Pair<>(INF, INF)));

        // Initialize the starting point
        toNum.put(new Pair<>(currx, curry), 1);
        toCoord.set(1, new Pair<>(currx, curry));


        int curr = 2;
        int steps = 1;
        // Generate the spiral and store composite numbers
        while (curr <= 10000) {
            for (int i = 0; i < 4 && curr <= 10000; i++) {
                for (int j = 0; j < steps && curr <= 10000; j++) {
                    if (i == 0) curry--;
                    if (i == 1) currx--;
                    if (i == 2) curry++;
                    if (i == 3) currx++;

                    if (!isPrime(curr)) {
                        toNum.put(new Pair<>(currx, curry), curr);
                        toCoord.set(curr, new Pair<>(currx, curry));
                    }

                    curr++;
                }
                if (i % 2 == 1) steps++;
            }
        }

        Scanner sc = new Scanner(System.in);
        int num = 1;
        // Process each test case
        while (sc.hasNextInt()) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            System.out.print("Case " + num++ + ": ");

            // Map to store the visited coordinates and their distances
            Map<Pair<Integer, Integer>, Integer> vis = new HashMap<>();
            // Queue for BFS
            Queue<Pair<Integer, Integer>> q = new LinkedList<>();
            q.add(toCoord.get(n1));

            // Perform BFS to find the shortest path
            while (!q.isEmpty()) {
                Pair<Integer, Integer> currPair = q.poll();

                for (int i = 0; i < 4; i++) {
                    int nextx = currPair.getKey() + dx[i];
                    int nexty = currPair.getValue() + dy[i];
                    Pair<Integer, Integer> nextPair = new Pair<>(nextx, nexty);

                    if (!toNum.containsKey(nextPair)) continue;
                    if (vis.containsKey(nextPair)) continue;

                    vis.put(nextPair, vis.getOrDefault(currPair, 0) + 1);
                    q.add(nextPair);
                }
            }

            // Output the result
            if (vis.getOrDefault(toCoord.get(n2), 0) == 0 && n1 != n2) {
                System.out.println("impossible");
            } else {
                System.out.println(vis.get(toCoord.get(n2)));
            }
        }
        sc.close();
    }

    // Helper class to represent a pair of integers
    static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(key, pair.key) && Objects.equals(value, pair.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }
}