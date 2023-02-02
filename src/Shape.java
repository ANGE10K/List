import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface Shape extends Comparable<Shape> {

    public static void main(String[] args) {
        Shape pyramid = new Pyramid(15,3);
        Shape cylinder = new Cylinder(5,600);
        Box box = new Box(100);
        box.add(pyramid);
        box.add(cylinder);
        List<Shape> shapes = box.getBox();
        Collections.sort(shapes);
    }

     double getVolume();

    default int compareTo(Shape shape) {
        if (this.getVolume() < shape.getVolume()) {
            return -1;
        } else if(this.getVolume() > shape.getVolume()) {
            return 1;
        } else return 0;
    }

}

class Pyramid implements Shape {
    private double s;
    private double h;

    Pyramid(double s, double h) {
        setH(h);
        setS(s);
    }

    public double getS() {
        return s;
    }

    public void setS(double s) {
        this.s = s;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }
    @Override
    public double getVolume() {
        return 1.0 / 3 * s * h;
    }
}

class Box implements Shape {
    private double volume;
   final private List<Shape> box = new ArrayList<>();
    Box(double volume) {
        setVolume(volume);
    }
    public boolean add(Shape shape) {
        if (shape.getVolume() < getVolume()) {
            box.add(shape);
            return true;
        } else return false;
    }

    @Override
    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
    public List<Shape> getBox() {
        return box;
    }
}
    abstract class SolidOfRevolution implements Shape {
        protected double radius;

        SolidOfRevolution(double radius) {
            this.radius = radius;
        }

        public double getRadius() {
            return radius;
        }

        public void setRadius(double radius) {
            this.radius = radius;
        }
        protected void test() {

        }
    }

class Cylinder extends SolidOfRevolution {
private double height;

Cylinder(double radius, double height) {
    super(radius);
    setHeight(height);
    setRadius(radius);
}

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    @Override
    public double getVolume() {
        return Math.PI * radius * height;
    }

}


