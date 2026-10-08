package ru.bochkarev.geometry;

class ColoredPoint extends Point {
    private String color;

    public ColoredPoint(double x, double y, String color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public String toString() {
        if (color == null || color.isEmpty()) {
            return super.toString();
        }
        return "Точка в координате {" + (int)getX() + ";" + (int)getY() + "}, цвет: " + color;
    }
}

class TimedPoint3D extends Point3D {
    private String time;

    public TimedPoint3D(double x, double y, double z, String time) {
        super(x, y, z);
        this.time = time;
    }

    @Override
    public String toString() {
        return "Точка в координате {" + (int)getX() + ";" + (int)getY() + ";" + (int)getZ() + "} в " + time;
    }
}

class TimedColoredPoint extends Point {
    private String time;
    private String color;

    public TimedColoredPoint(double x, double y, String time, String color) {
        super(x, y);
        this.time = time;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Точка в координате {" + (int)getX() + ";" + (int)getY() + "} в " + time + ", цвет: " + color;
    }
}

public class PointFeatures {
    public static void showExamples() {
        Point p1 = new ColoredPoint(3, 0, "красный");
        System.out.println("• " + p1);

        Point p2 = new TimedPoint3D(4, 2, 5, "11:00");
        System.out.println("• " + p2);

        Point p3 = new TimedColoredPoint(7, 7, "15:35", "желтый");
        System.out.println("• " + p3);
    }
}
