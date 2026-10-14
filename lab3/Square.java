package ru.bochkarev.geometry;
public class Square {
    private Point topLeft;
    private double side;

    public Square(Point topLeft, double side) {
        this.topLeft = new PointFeatures (topLeft.getX(), topLeft.getY());
        this.side = side;
    }

        public Square(double x, double y, double side) {
        this.topLeft = new PointFeatures(x, y);
        this.side = side;
    }

    public Lomanaya getLomanaya() {
        Point[] corners = new Point[4];
        double x = topLeft.getX();
        double y = topLeft.getY();

        corners[0] = new PointFeatures(x, y);
        corners[1] = new PointFeatures(x + side, y);
        corners[2] = new PointFeatures(x + side, y + side);
        corners[3] = new PointFeatures(x, y + side);

        return new Lomanaya(corners);
    }


    @Override
    public String toString() {
        String sideStr = (side == (long) side) ? String.format("%d", (long) side) : String.format("%s", side);
        return "Квадрат в точке " + topLeft + " со стороной " + sideStr;
    }
}
