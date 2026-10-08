package ru.bochkarev.geometry;

public class Point3D extends Point {
    private double z;

    public Point3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double getZ() { return z; }
    public void setZ(double z) { this.z = z; }

    @Override
    public String toString() {
        String xStr = (getX() == (long) getX()) ? String.format("%d", (long) getX()) : String.format("%s", getX());
        String yStr = (getY() == (long) getY()) ? String.format("%d", (long) getY()) : String.format("%s", getY());
        String zStr = (z == (long) z) ? String.format("%d", (long) z) : String.format("%s", z);
        return "{" + xStr + ";" + yStr + ";" + zStr + "}";
    }
}
