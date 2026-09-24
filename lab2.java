import java.util.Arrays;

public class lab2 {
    public static void main(String[] args) {
        System.out.println("ЗАДАНИЕ 1");
        Point p1 = new Point(1.0, 2.5);
        Point p2 = new Point(-3.4, 0.0);
        Point p3 = new Point(5.0, -12.1);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        System.out.println("\nЗАДАНИЕ 2");
        Point line1Start = new Point(1, 3);
        Point line1End = new Point(23, 8);
        Line line1 = new Line(line1Start, line1End);

        Point line2Start = new Point(5, 10);
        Point line2End = new Point(25, 10);
        Line line2 = new Line(line2Start, line2End);

        Line line3 = new Line(line1Start, line2End);

        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);

        line1Start.setX(10); 
        line2End.setY(50);   
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);

        line1.setStart(new Point(99, 99)); 
        System.out.println(line1);
        System.out.println(line3);

        System.out.println("\nЗАДAНИЕ 3");
        Student vasya = new Student("Вася", new int[]{3, 4, 5});
        Student petya = new Student("Петя", vasya.getGrades());

        petya.getGrades()[0] = 5;

        System.out.println(vasya);
        System.out.println(petya);

        int[] andreyGrades = Arrays.copyOf(vasya.getGrades(), vasya.getGrades().length);
        Student andrey = new Student("Андрей", andreyGrades);

        vasya.getGrades()[0] = 2;

        System.out.println(vasya);
        System.out.println(andrey);

        System.out.println("\nЗАДАНИЕ 4(1)");
        Point task4P1 = new Point(3, 5);
        Point task4P2 = new Point(25, 6);
        Point task4P3 = new Point(7, 8);
        System.out.println(task4P1);
        System.out.println(task4P2);
        System.out.println(task4P3);

        System.out.println("\nЗАДАНИЕ 4(2)");
        Line task4Line1 = new Line(1, 3, 23, 8);
        Line task4Line2 = new Line(5, 10, 25, 10);
        Line task4Line3 = new Line(task4Line1.getStart(), task4Line2.getEnd());
        System.out.println(task4Line1);
        System.out.println(task4Line2);
        System.out.println(task4Line3);

        System.out.println("\nЗАДАНИЕ 5");
        Line task5Line = new Line(1, 1, 10, 15);
        System.out.println("Длина линии: " + task5Line.getLength());
    }
}
