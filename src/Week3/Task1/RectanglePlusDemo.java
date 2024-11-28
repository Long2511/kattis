package Week3.Task1;

import java.awt.*;

public class RectanglePlusDemo {
    public static void main(String[] args) {
        // Create several objects using all constructors
        RectanglePlus rect1 = new RectanglePlus();
        RectanglePlus rect2 = new RectanglePlus(new Point(10, 10));
        RectanglePlus rect3 = new RectanglePlus(20, 30);
        RectanglePlus rect4 = new RectanglePlus(new Point(5, 5), 15, 25);
        RectanglePlus rect4Clone = null;


        // Call all methods and output information
        System.out.println("Rectangle 1 area: " + rect1.getArea());
        System.out.println("Rectangle 2 area: " + rect2.getArea());
        System.out.println("Rectangle 3 area: " + rect3.getArea());
        System.out.println("Rectangle 4 area: " + rect4.getArea());

        rect1.move(3, 3);
        System.out.println("Rectangle 1 moved to: (" + rect1.origin.x + ", " + rect1.origin.y + ")");

        // Use methods from the Object class on the last created object
        try {
            rect4Clone = (RectanglePlus) rect4.clone();
            System.out.println("Rectangle 4 clone created.");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println("Task 4 clone: " + rect4Clone);
        System.out.println("Rectangle 4 equals Rectangle 3: " + rect4.equals(rect3));
        System.out.println("Rectangle 4 class: " + rect4.getClass());
        System.out.println("Rectangle 4 hash code: " + rect4.hashCode());
        System.out.println("Rectangle 4 toString: " + rect4);
    }
}