package Week4.Task1;

public class ValueOfDemo {
    public static void main(String[] args) {
        int num = 123;
        boolean flag = true;
        double pi = 3.14159;

        String numStr = String.valueOf(num);
        String flagStr = String.valueOf(flag);
        String piStr = String.valueOf(pi);

        System.out.println("Integer as string: " + numStr);
        System.out.println("Boolean as string: " + flagStr);
        System.out.println("Double as string: " + piStr);
    }
}