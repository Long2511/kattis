package Week2.Task2;

public class MountainBike extends Bicycle {
    private int seatHeight;

    public MountainBike(int startHeight, int startCadence,
                        int startSpeed, int startGear) {
        super(startCadence, startSpeed, startGear);
        seatHeight = startHeight;
    }

    public void setHeight(int newValue) {
        seatHeight = newValue;
    }

    @Override
    public void printDescription() {
        super.printDescription();
        System.out.println("The MountainBike has a seat height of " + seatHeight + " inches.");
    }
}