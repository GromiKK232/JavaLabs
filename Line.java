package ru.bochkarev.geometry;

public class Line implements Cloneable {
    private Point start;
    private Point end;

    public Line(Point start, Point end) {
        this.start = new Point(start.getX(), start.getY());
        this.end = new Point(end.getX(), end.getY());
    }

    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    public int getLength() {
        double dx = end.getX() - start.getX();
        double dy = end.getY() - start.getY();
        return (int) Math.sqrt(dx * dx + dy * dy);
    }

    public Point getStart() { 
        return new Point(this.start.getX(), this.start.getY()); 
    }
    
    public void setStart(Point start) { 
        this.start = new Point(start.getX(), start.getY()); 
    }

    public Point getEnd() { 
        return new Point(this.end.getX(), this.end.getY()); 
    }
    
    public void setEnd(Point end) { 
        this.end = new Point(end.getX(), end.getY()); 
    }

    public double getStartX() { return start.getX(); }
    public double getStartY() { return start.getY(); }
    public double getEndX() { return end.getX(); }
    public double getEndY() { return end.getY(); }

    public void setStartCoordinates(double x, double y) {
        this.start = new Point(x, y);
    }
    
    public void setEndCoordinates(double x, double y) {
        this.end = new Point(x, y);
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
