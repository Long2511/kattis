package Week2.L;

import java.util.*;

public class CuChiTunnels {
    static class Node {
        int degree;
        boolean isRoot;

        Node(int degree, boolean isRoot) {
            this.degree = degree;
            this.isRoot = isRoot;
        }
    }

    public static boolean IsValidTunnel(int n, Iterator<Integer> it) {
        try {
            Stack<Node> stack = new Stack<>();
            if (!it.hasNext()) {
                return false;
            }
            stack.push(new Node(it.next(), true));
            int c = 0;
            int total = 0;

            while (c < n && !stack.isEmpty()) {
                Node node = stack.pop();
                int children = node.degree;
                boolean isRoot = node.isRoot;
                c++;
                total += children;
                if (!isRoot) {
                    children -= 1;
                }
                for (int i = 0; i < children; i++) {
                    if (!it.hasNext()) {
                        return false;
                    }
                    stack.push(new Node(it.next(), false));
                }
            }
            return stack.isEmpty() && total == 2 * (n - 1);
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> degrees = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            degrees.add(sc.nextInt());
        }

        if (IsValidTunnel(n, degrees.iterator())) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
