
/**
 * Advanced Object Oriented Programming with Java, WiSe 2023/2024
 * Problem: <a href="https://open.kattis.com/problems/knitpicking">Knitpicking</a>
 * @author Hai Long Mac
 *
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.16
 */
package Week4.Task6.B;

import java.util.HashMap;
import java.util.Scanner;

public class Knitpicking {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int totalSocks = 0;
        // ArrayList<Chaussette> list = new ArrayList<>();
        HashMap<String, Chaussette> list = new HashMap<>();
        for (int i = 0; i < n; i++) { //reading input
            String type = sc.next(); //reading of the type of sock
            if (!list.containsKey(type)) { //chaussette does not exists
                Chaussette c = new Chaussette(type);
                String fit = sc.next();
                int count = sc.nextInt();
                totalSocks += count;
                switch (fit) {
                    case "any":
                        c.anyCount = count;
                        break;
                    case "left":
                        c.leftCount = count;
                        break;
                    case "right":
                        c.rightCount = count;
                        break;
                    default:
                        break;
                }
                list.put(type, c);
            } else { //Chaussette already exixts
                Chaussette c = list.get(type);
                String fit = sc.next();
                int count = sc.nextInt();
                totalSocks += count;
                switch (fit) {
                    case "any":
                        c.anyCount = count;
                        break;
                    case "left":
                        c.leftCount = count;
                        break;
                    case "right":
                        c.rightCount = count;
                        break;
                    default:
                        break;
                }
                list.replace(type, c);
            }
        } //reading done, calculation starts
        int ans = 0;
        for (String type : list.keySet()) {
            Chaussette c = list.get(type);
            if (c.leftCount == 0 && c.rightCount == 0) ans++;
            else {
                ans += Math.max(c.leftCount, c.rightCount);
            }
        }

        if (ans + 1 > totalSocks) System.out.println("impossible");
        else System.out.println(ans + 1);

    }
}

class Chaussette {

    String type;
    int leftCount;
    int rightCount;
    int anyCount;

    public Chaussette(String type) {
        this.type = type;
    }

    int pairs(int leftCount, int rightCount, int anyCount) {
        int pairs = 0;
        int remainder = Math.abs(leftCount - rightCount);
        pairs += Math.min(leftCount, rightCount);
        pairs += Math.min(remainder, anyCount);
        anyCount -= remainder;
        pairs += anyCount / 2;
        return pairs;
    }

}