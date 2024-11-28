package Week1.Task3;

public class RandomSeqAB {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int n = Integer.parseInt(args[2]);

        if (a < b) {
            for (int i = 0; i < n; i++) {
                int random = a + (int) (Math.random() * (b - a + 1));
                System.out.println(random);
            }
        } else if (a > b) {
            for (int i = 0; i < n; i++) {
                int random = b + (int) (Math.random() * (a - b + 1));
                System.out.println(random);
            }
        }
    }
}