package Week2.Task2;

public class Main {
    public static void main(String[] args) {
        // Create several Bicycle objects using different constructors
        Bicycle bike1 = new Bicycle(30, 10, 1);
        MountainBike bike2 = new MountainBike(5, 20, 15, 2);

        // Call all methods and output appropriate information
        bike1.printDescription();
        bike1.setCadence(40);
        bike1.speedUp(10);
        bike1.applyBrake(5);
        bike1.printDescription();

        System.out.println("\n");

        bike2.printDescription();
        bike2.setHeight(10);
        bike2.setCadence(25);
        bike2.speedUp(5);
        bike2.applyBrake(2);
        bike2.printDescription();
    }
}