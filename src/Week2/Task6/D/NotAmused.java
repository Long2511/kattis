
/**
 * Advanced Object Oriented Programming with Java, WiSe 2023/2024
 * Problem: <a href="https://open.kattis.com/problems/notamused">Not Amused</a>
 * @author Hai Long Mac
 *
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.26
 */
package Week2.Task6.D;

import java.util.*;

public class NotAmused {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Integer>> numberOfEntries = new TreeMap<>();

        String status;
        int count = 1;


        boolean first = true;

        while (scanner.hasNext()) {
            status = scanner.next();

            if (status.equals("OPEN")) {
                if (first) {
                    first = false;
                } else {
                    System.out.println();
                }

                System.out.println("Day " + count);
                count++;
                continue;
            }

            if (status.equals("CLOSE")) {
                for (Map.Entry<String, List<Integer>> entry : numberOfEntries.entrySet()) {
                    double total = 0;
                    List<Integer> timeList = entry.getValue();
                    for (int j = 0; j < timeList.size(); j += 2) {
                        total += timeList.get(j + 1) - timeList.get(j);
                    }
                    total /= 10;
                    System.out.printf("%s $%.2f%n", entry.getKey(), total);
                }

                numberOfEntries.clear();

                continue;
            }

            String name = scanner.next();
            int time = scanner.nextInt();
            numberOfEntries.computeIfAbsent(name, k -> new ArrayList<>()).add(time);
        }

        scanner.close();
    }
}
