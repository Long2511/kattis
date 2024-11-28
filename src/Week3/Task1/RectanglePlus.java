package Week3.Task1;

import java.awt.*;
import java.util.Objects;

public class RectanglePlus implements Relatable, Cloneable {
    public int width = 0;
    public int height = 0;
    public Point origin;

    // four constructors
    public RectanglePlus() {
        origin = new Point(0, 0);
    }
    public RectanglePlus(Point p) {
        origin = p;
    }
    public RectanglePlus(int w, int h) {
        origin = new Point(0, 0);
        width = w;
        height = h;
    }
    public RectanglePlus(Point p, int w, int h) {
        origin = p;
        width = w;
        height = h;
    }

    // a method for moving the rectangle
    public void move(int x, int y) {
        origin.x = x;
        origin.y = y;
    }

    // a method for computing
    // the area of the rectangle
    public int getArea() {
        return width * height;
    }

    // a method required to implement
    // the Relatable interface
    public int isLargerThan(Relatable other) {
        RectanglePlus otherRect
                = (RectanglePlus)other;
        if (this.getArea() < otherRect.getArea())
            return -1;
        else if (this.getArea() > otherRect.getArea())
            return 1;
        else
            return 0;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (getClass() != obj.getClass()) return false;
        RectanglePlus that = (RectanglePlus) obj;
        return width == that.width && height == that.height
                && Objects.equals(origin, that.origin);
    }
    @Override
    public int hashCode() {
        return Objects.hash(width, height, origin);
    }
    @Override
    public String toString() {
        return "RectanglePlus{" +
                "width=" + width +
                ", height=" + height +
                ", origin=" + origin +
                '}';
    }
}