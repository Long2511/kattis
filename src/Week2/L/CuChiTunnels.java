package Week2.L;

import java.util.Scanner;


public class CuChiTunnels {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        if (N < 2 || N > 100) {
            System.out.println("NO");
            return;
        }

        int[] degrees = new int[N];
        int sumDegrees = 0;
        boolean isValid = true;

        for (int i = 0; i < N; i++) {
            int Di = sc.nextInt();
            if (Di < 1 || Di > N - 1) {
                isValid = false;
                break;
            }
            degrees[i] = Di;
            sumDegrees += Di;
        }

        if (!isValid || sumDegrees != 2 * (N - 1)) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}

