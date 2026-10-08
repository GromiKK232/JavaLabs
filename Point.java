package ru.bochkarev.geometry;

public class Point implements Cloneable {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point other = (Point) obj;
        return Double.compare(this.x, other.x) == 0 && Double.compare(this.y, other.y) == 0;
    }

    @Override
    public Point clone() {
        try {
            return (Point) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        String xStr = (x == (long) x) ? String.format("%d", (long) x) : String.format("%s", x);
        String yStr = (y == (long) y) ? String.format("%d", (long) y) : String.format("%s", y);
        return "{" + xStr + ";" + yStr + "}";
    }
}
