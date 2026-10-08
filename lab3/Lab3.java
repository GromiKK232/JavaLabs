package ru.bochkarev.main;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

import ru.bochkarev.data.NeizmenyaemiMassive;
import ru.bochkarev.geometry.*;
import java.util.Scanner;

public class Lab3 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        if (args.length >= 2) {
            try {
                double result = powerOf(args[0], args[1]);
                System.out.println("Результат возведения " + args[0] + " в степень " + args[1] + " равен: " + result);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Аргументы командной строки должны быть целыми числами.");
            }
            return;
        }

        boolean running = true;

        while (running) {
            System.out.println("\nМЕНЮ:");
            System.out.println("1. Линия (и сравнение линий)");
            System.out.println("2. Квадрат и Ломаная");
            System.out.println("3. Неизменяемый массив");
            System.out.println("4. Трехмерная точка");
            System.out.println("5. Комбинированные точки");
            System.out.println("6. Сложение чисел и дробей");
            System.out.println("7. Интерактивное возведение в степень");
            System.out.println("8. Клонирование линии");
            System.out.println("0. Выход");

            int choice = readInt("Выберите пункт: ");

            switch (choice) {
                case 1:
                    runLineTask();
                    break;
                case 2:
                    runSquareTask();
                    break;
                case 3:
                    runNeizmenyaemiMassiveTask();
                    break;
                case 4:
                    runPoint3DTask();
                    break;
                case 5:
                    runPointFeaturesTask();
                    break;
                case 6:
                    runSumTask();
                    break;
                case 7:
                    runInteractivePowerTask();
                    break;
                case 8:
                    runCloneLineTask();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный пункт меню.");
            }
        }
    }

    public static double powerOf(String xStr, String yStr) {
        int x = parseInt(xStr);
        int y = parseInt(yStr);
        return pow(x, y);
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка. Введите целое число.");
            }
        }
    }

    private static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine().trim().replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.println("Ошибка. Введите число.");
            }
        }
    }

    private static String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    public static double sum(double... values) {
        double result = 0;
        for (double val : values) {
            result += val;
        }
        return result;
    }

    private static void runLineTask() {
        System.out.println("Создание линии 1:");
        double x1 = readDouble("Введите x1: ");
        double y1 = readDouble("Введите y1: ");
        double x2 = readDouble("Введите x2: ");
        double y2 = readDouble("Введите y2: ");
        Line line1 = new Line(x1, y1, x2, y2);

        System.out.println("\nСоздание линии 2 (для сравнения):");
        double x3 = readDouble("Введите x3: ");
        double y3 = readDouble("Введите y3: ");
        double x4 = readDouble("Введите x4: ");
        double y4 = readDouble("Введите y4: ");
        Line line2 = new Line(x3, y3, x4, y4);

        System.out.println("\nЛиния 1: " + line1);
        System.out.println("Линия 2: " + line2);
        
        if (line1.equals(line2)) {
            System.out.println("Результат сравнения: Линии ОДИНАКОВЫЕ");
        } else {
            System.out.println("Результат сравнения: Линии РАЗНЫЕ");
        }
    }

    private static void runSquareTask() {
        Square square = new Square(5, 3, 23);
        System.out.println("1. " + square);

        Lomanaya lomanaya = square.getLomanaya();
        System.out.println("2. " + lomanaya);

        System.out.printf("3. Длина ломаной: %.2f\n", lomanaya.getLength());

        Point[] pts = lomanaya.getPoints();
        Point lastPoint = pts[pts.length - 1];
        lastPoint.setX(15);
        lastPoint.setY(25);
        System.out.println("4. Последняя точка сдвинута");

        System.out.println("   " + lomanaya);
        System.out.printf("5. Новая длина ломаной: %.2f\n", lomanaya.getLength());

        double x = readDouble("Введите X квадрата: ");
        double y = readDouble("Введите Y квадрата: ");
        double side = readDouble("Введите сторону квадрата: ");

        Square userSquare = new Square(x, y, side);
        System.out.println(userSquare);
        Lomanaya userLomanaya = userSquare.getLomanaya();
        System.out.printf("Длина ломаной вашего квадрата: %.2f\n", userLomanaya.getLength());
    }

    private static void runNeizmenyaemiMassiveTask() {
        int size = readInt("Размер массива: ");
        if (size < 0) {
            System.out.println("Размер не может быть отрицательным.");
            return;
        }

        int[] userArray = new int[size];
        for (int i = 0; i < size; i++) {
            userArray[i] = readInt("Элемент [" + i + "]: ");
        }

        NeizmenyaemiMassive massive = new NeizmenyaemiMassive(userArray);
        System.out.println("Создан массив: " + massive);
        System.out.println("Размер: " + massive.getSize());
        System.out.println("Массив пуст: " + massive.isEmpty());

        if (massive.getSize() > 0) {
            int idxToGet = readInt("Индекс для чтения: ");
            try {
                int val = massive.getValue(idxToGet);
                System.out.println("Значение: " + val);
            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }

            int idxToSet = readInt("Индекс для замены: ");
            int newVal = readInt("Новое значение: ");
            try {
                massive.setValue(idxToSet, newVal);
                System.out.println("Обновленный массив: " + massive);
            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void runPoint3DTask() {
        double x = readDouble("Введите X: ");
        double y = readDouble("Введите Y: ");
        double z = readDouble("Введите Z: ");

        Point3D p3d = new Point3D(x, y, z);
        System.out.println("Создана трехмерная точка: " + p3d);

        double newZ = readDouble("Введите новое значение Z: ");
        p3d.setZ(newZ);
        System.out.println("Обновленная точка: " + p3d);
    }

    private static void runPointFeaturesTask() {
        System.out.println("Выберите размерность (1 - Одномерная, 2 - Двумерная, 3 - Трехмерная): ");
        int dim = readInt("Ввод: ");

        Point p;
        if (dim == 1) {
            int x = readInt("Введите X: ");
            p = new Point(x, 0); 
        } else if (dim == 3) {
            int x = readInt("Введите X: ");
            int y = readInt("Введите Y: ");
            int z = readInt("Введите Z: ");
            p = new Point3D(x, y, z);
        } else {
            int x = readInt("Введите X: ");
            int y = readInt("Введите Y: ");
            p = new Point(x, y);
        }

        String color = readString("Введите цвет: ");
        String time = readString("Введите время появления: ");

        PointFeatures pf = new PointFeatures(p, color, time);
        System.out.println("Результат: " + pf);
    }

    private static void runSumTask() {
        System.out.println("Выполнение сложений из задания:");

        double res1 = sum(2, 3.0 / 5.0, 2.3);
        System.out.println("• 2 + 3/5 + 2.3 = " + res1);

        double res2 = sum(3.6, 49.0 / 12.0, 3, 3.0 / 2.0);
        System.out.println("• 3.6 + 49/12 + 3 + 3/2 = " + res2);

        double res3 = sum(1.0 / 3.0, 1);
        System.out.println("• 1/3 + 1 = " + res3);

        System.out.println("\nИнтерактивное сложение двух вещественных чисел:");
        double a = readDouble("Введите первое число: ");
        double b = readDouble("Введите второе число: ");
        System.out.println("Сумма введённых чисел: " + sum(a, b));
    }

    private static void runInteractivePowerTask() {
        String xStr = readString("Введите число X: ");
        String yStr = readString("Введите степень Y: ");
        try {
            double res = powerOf(xStr, yStr);
            System.out.println("Результат: " + res);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка преобразования строки в число.");
        }
    }

    private static void runCloneLineTask() {
        System.out.println("Создание исходной линии:");
        double x1 = readDouble("Введите x1: ");
        double y1 = readDouble("Введите y1: ");
        double x2 = readDouble("Введите x2: ");
        double y2 = readDouble("Введите y2: ");
        
        Line original = new Line(x1, y1, x2, y2);
        System.out.println("Оригинальная линия: " + original);
        Line clone = original.clone();
System.out.println("Клонированная линия: " + clone);
System.out.println("\nМеняем координаты конца у КЛОНИРОВАННОЙ линии...");
clone.setEndCoordinates(99, 99);
System.out.println("Оригинальная линия после этого: " + original);
System.out.println("Клонированная линия после этого: " + clone);
}
}

