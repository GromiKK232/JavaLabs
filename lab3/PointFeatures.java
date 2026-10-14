package ru.bochkarev.geometry;

public class PointFeatures extends Point {
    private String color;
    private String time;

    public PointFeatures(double x, double y) {
        super(x, y);
    }

    public PointFeatures(double x, double y, String color) {
        super(x, y);
        this.color = color;
    }

    public PointFeatures(double x, double y, String color, String time) {
        super(x, y);
        this.color = color;
        this.time = time;
    }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    @Override
    public String toString() {
        String result = "Точка в координате " + super.toString();
        if (color != null && !color.isEmpty()) {
            result += ", цвет: " + color;
        }
        if (time != null && !time.isEmpty()) {
            result += ", время появления: " + time;
        }
        return result;
    }
}
