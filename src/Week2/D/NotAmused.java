package Week2.D;

import java.util.*;

public class NotAmused {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean firstDay = true;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.equals("CLOSE")) {
                break;
            }
            if (line.equals("OPEN")) {
                if (!firstDay) {
                    System.out.println();
                }
                firstDay = false;

                Map<String, Integer> entryTime = new HashMap<>();
                Map<String, Integer> totalTime = new HashMap<>();

                while (scanner.hasNextLine()) {
                    line = scanner.nextLine().trim();
                    if (line.equals("CLOSE")) {
                        break;
                    }

                    String[] parts = line.split(" ");
                    String action = parts[0];
                    String name = parts[1];
                    int time = Integer.parseInt(parts[2]);

                    if (action.equals("ENTER")) {
                        entryTime.put(name, time);
                    } else if (action.equals("EXIT")) {
                        int enterTime = entryTime.get(name);
                        int duration = time - enterTime;
                        totalTime.put(name, totalTime.getOrDefault(name, 0) + duration);
                        entryTime.remove(name);
                    }
                }

                List<String> customers = new ArrayList<>(totalTime.keySet());
                Collections.sort(customers);

                for (String customer : customers) {
                    int minutesSpent = totalTime.get(customer);
                    double bill = minutesSpent * 0.10;
                    System.out.printf("%s $%.2f%n", customer, bill);
                }
            }
        }

        scanner.close();
    }
}
