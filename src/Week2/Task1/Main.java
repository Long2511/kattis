package Week2.Task1;

public class Main {
    public static void main(String[] args) {
        // Create several objects using different constructors
        Point point1 = new Point(10, 20);
        Point point2 = new Point(30, 40);

        Rectangle rect1 = new Rectangle();
        Rectangle rect2 = new Rectangle(point1);
        Rectangle rect3 = new Rectangle(50, 60);
        Rectangle rect4 = new Rectangle(point2, 70, 80);

        // Call all methods and output appropriate information
        rect1.print();
        rect2.print();
        rect3.print();
        rect4.print();

        rect1.move(5, 5);
        System.out.println("After moving rect1:");
        rect1.print();

        System.out.println("Area of rect2: " + rect2.getArea());
        System.out.println("Area of rect3: " + rect3.getArea());
        System.out.println("Area of rect4: " + rect4.getArea());
    }
}