package Week1.Task1;

public class Quadratic {
    public static void main(String[] args) {
        double b = Double.parseDouble(args[0]);
        double c = Double.parseDouble(args[1]);

        double discriminant = b * b - 4.0 * c;

        if (discriminant > 0) {
            double sqrt = Math.sqrt(discriminant);

            double root1 = (-b + sqrt) / 2.0;
            double root2 = (-b - sqrt) / 2.0;

            System.out.println("The roots are real and different.");
            System.out.println("Root 1: " + root1);
            System.out.println("Root 2: " + root2);
        } else if (discriminant == 0) {
            double root = -b / 2.0;
            System.out.println("The root is real and the same.");
            System.out.println("Root: " + root);
        } else {
            double root = -b / 2.0;
            double imaginary = Math.sqrt(-discriminant) / 2.0;
            System.out.println("The roots are complex and different.");
            System.out.println("Root 1: " + root + " + " + imaginary + "i");
            System.out.println("Root 2: " + root + " - " + imaginary + "i");
        }
    }
}