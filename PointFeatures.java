package ru.bochkarev.geometry;
public class PointFeatures {
    private Point point;
    private String color;
    private String time;

    public PointFeatures(Point point) {
        this.point = point;
    }

    public PointFeatures(Point point, String color) {
        this.point = point;
        this.color = color;
    }

    public PointFeatures(Point point, String color, String time) {
        this.point = point;
        this.color = color;
        this.time = time;
    }

    public Point getPoint() { return point; }
    public void setPoint(Point point) { this.point = point; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    @Override
    public String toString() {
        String result = "Точка в координате " + point.toString();
        if (color != null && !color.isEmpty()) {
            result += ", цвет: " + color;
        }
        if (time != null && !time.isEmpty()) {
            result += ", время появления: " + time;
        }
        return result;
    }
}
