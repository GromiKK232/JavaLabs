package ru.bochkarev.geometry;

public class Lomanaya {
    private Point[] points;

    public Lomanaya(Point[] points) {
        this.points = points;
    }

    public Point[] getPoints() {
        return points;
    }

    public double getLength() {
        double totalLength = 0;
        for (int i = 0; i < points.length - 1; i++) {
            Point p1 = points[i];
            Point p2 = points[i + 1];
            double dx = p2.getX() - p1.getX();
            double dy = p2.getY() - p1.getY();
            totalLength += Math.sqrt(dx * dx + dy * dy);
        }
        return totalLength;
    }

    @Override
    public String toString() {
        String result = "Ломаная линия [";
        for (int i = 0; i < points.length; i++) {
            result += points[i].toString();
            if (i < points.length - 1) {
                result += ", ";
            }
        }
        result += "]";
        return result;
    }
}
