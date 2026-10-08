package ru.bochkarev.geometry;

public class Line implements Cloneable {
    private Point start;
    private Point end;

    public Line(Point start, Point end) {
        this.start = start.clone();
        this.end = end.clone();
    }

    public Line(double x1, double y1, double x2, double y2) {
        this.start = new ColoredPoint(x1, y1, "");
        this.end = new ColoredPoint(x2, y2, "");
    }

    public int getLength() {
        double dx = end.getX() - start.getX();
        double dy = end.getY() - start.getY();
        return (int) Math.sqrt(dx * dx + dy * dy);
    }

    public Point getStart() { return this.start.clone(); }
    public void setStart(Point start) { this.start = start.clone(); }

    public Point getEnd() { return this.end.clone(); }
    public void setEnd(Point end) { this.end = end.clone(); }

    public double getStartX() { return start.getX(); }
    public double getStartY() { return start.getY(); }
    public double getEndX() { return end.getX(); }
    public double getEndY() { return end.getY(); }

    public void setStartCoordinates(double x, double y) {
        this.start.setX(x);
        this.start.setY(y);
    }
    
    public void setEndCoordinates(double x, double y) {
        this.end.setX(x);
        this.end.setY(y);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Line other = (Line) obj;
        boolean directMatch = this.start.equals(other.start) && this.end.equals(other.end);
        boolean reverseMatch = this.start.equals(other.end) && this.end.equals(other.start);
        return directMatch || reverseMatch;
    }

    @Override
    public Line clone() {
        try {
            Line cloned = (Line) super.clone();
            cloned.start = this.start.clone();
            cloned.end = this.end.clone();
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Линия от " + start + " до " + end;
    }
}
