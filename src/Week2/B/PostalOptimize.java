package Week2.B;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PostalOptimize {
    private static int CalculateTotalDistance(List<int[]> locations, int capacity) {
        int distance = 0;

        for (int i = 0; i < locations.size(); ) {
            int currentCapacity = 0;
            int longestDistanceToLocation = locations.get(i)[0];

            while (i < locations.size() && currentCapacity < capacity) {
                int[] location = locations.get(i);
                int letters = Math.min(location[1], capacity - currentCapacity);

                currentCapacity += letters;
                location[1] -= letters;

                if (location[1] == 0) {
                    i++;
                }
            }

            distance += 2 * longestDistanceToLocation;
        }

        return distance;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int K = scanner.nextInt();

        List<int[]> positiveLocations = new ArrayList<>();
        List<int[]> negativeLocations = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int x = scanner.nextInt();
            int t = scanner.nextInt();
            if (x > 0) {
                positiveLocations.add(new int[]{x, t});
            } else {
                negativeLocations.add(new int[]{Math.abs(x), t});
            }
        }

        positiveLocations.sort((a, b) -> b[0] - a[0]);
        negativeLocations.sort((a, b) -> b[0] - a[0]);

        int totalDistance = CalculateTotalDistance(positiveLocations, K) + CalculateTotalDistance(negativeLocations, K);

        System.out.println(totalDistance);
    }


}
