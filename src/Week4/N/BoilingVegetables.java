package Week4.N;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BoilingVegetables {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            float ratio = scanner.nextFloat();
            int n = scanner.nextInt();
            PriorityQueue<Pair> pq = new PriorityQueue<>(
                    (a, b) -> Float.compare((float) b.weight / b.divisor, (float) a.weight / a.divisor)
            );

            float minimal = (float) Math.pow(10, 7);
            for (int i = 0; i < n; i++) {
                int w = scanner.nextInt();
                pq.add(new Pair(w, 1));
                minimal = Math.min(minimal, w / 1.0f);
            }

            int res = 0;

            while (!pq.isEmpty()) {
                Pair top = pq.poll();

                if (minimal / ((float) top.weight / top.divisor) >= ratio) {
                    break;
                }

                pq.add(new Pair(top.weight, top.divisor + 1));
                minimal = Math.min(minimal, (float) top.weight / (top.divisor + 1));
                res++;
            }

            System.out.println(res);
        }
        scanner.close();
    }

    static class Pair {
        int weight;
        int divisor;

        Pair(int weight, int divisor) {
            this.weight = weight;
            this.divisor = divisor;
        }
    }
}
