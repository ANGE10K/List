import java.util.ArrayList;
import java.util.List;

public class Point {
    private double x;
    private double y;

   public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public boolean equals(Object obj) {
        if (!(obj instanceof Point)) {
            return false;
        }
        Point point = (Point) obj;
        return this.x == point.x && this.y == point.y;

    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
class Polygon {
    private List<Point> points = new ArrayList<>();
    public void addPoint(Point point) {
        points.add(point);
    }
}
