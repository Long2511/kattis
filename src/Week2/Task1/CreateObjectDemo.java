package Week2.Task1;

public class CreateObjectDemo {
    public static void main(String[] args) {
        Point originOne = new Point(23, 94);
        Rectangle rectOne = new Rectangle(originOne, 100, 200);
        Rectangle rectTwo = new Rectangle(50, 100);
        Rectangle rectThree = new Rectangle(originOne);
        Rectangle rectFour = new Rectangle(new Point(50, 100));

        rectOne.print();
        rectTwo.print();
        rectThree.print();
        rectFour.print();
    }
}
