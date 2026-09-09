import java.util.Scanner;
import java.util.Arrays;

public class lab1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x1_1 = 0;
        while (true) {
            System.out.print("\nЗадача 1.1 - Введите вещественное число: ");
            if (scanner.hasNextDouble()) {
                x1_1 = scanner.nextDouble();
                break;
            } else {
                System.out.println("Введено не вещественное число.");
                scanner.next(); 
            }
        }
        System.out.println("Дробная часть: " + fraction(x1_1));

        int x1_2 = 0;
        while (true) {
            System.out.print("\nЗадача 1.2 - Введите целое число: ");
            if (scanner.hasNextInt()) {
                x1_2 = scanner.nextInt();
                if (Math.abs(x1_2) >= 10) {
                    break; 
                } else {
                    System.out.println("В числе должно быть минимум два знака.");
                }
            } else {
                System.out.println("Введено не целое число.");
                scanner.next(); 
            }
        }
        System.out.println("Сумма двух последних цифр: " + sumLastNums(x1_2));

        // Задача 1.3: Символ в число
        char symbol = ' ';
        while (true) {
            System.out.print("\nЗадача 1.3 - Введите ОДИН символ-цифру (от 0 до 9): ");
            String inputStr = scanner.next();
            if (inputStr.length() == 1 && Character.isDigit(inputStr.charAt(0))) {
                symbol = inputStr.charAt(0);
                break;
            } else {
                System.out.println("Нужно ввести строго ОДИН символ и строго ЦИФРУ.");
            }
        }
        System.out.println("Преобразованное число: " + charToNum(symbol));

        // Задача 1.4: Проверка на положительность
        int x1_4 = 0;
        while (true) {
            System.out.print("\nЗадача 1.4 - Введите целое число для проверки на положительность: ");
            if (scanner.hasNextInt()) {
                x1_4 = scanner.nextInt();
                break;
            } else {
                System.out.println("Введено не целое число.");
                scanner.next();
            }
        }
        System.out.println("Число положительное? -> " + isPositive(x1_4));

        int x1_5 = 0;
        while (true) {
            System.out.print("\nЗадача 1.5 - Введите целое число для проверки на двузначность: ");
            if (scanner.hasNextInt()) {
                x1_5 = scanner.nextInt();
                break;
            } else {
                System.out.println("Введено не целое число.");
                scanner.next();
            }
        }
        System.out.println("Число двузначное?  " + is2Digits(x1_5));

        int x2_1 = 0;
        while (true) {
            System.out.print("\nЗадача 2.1 - Введите целое число для получения модуля: ");
            if (scanner.hasNextInt()) {
                x2_1 = scanner.nextInt();
                break;
            } else {
                System.out.println("Введено не целое число.");
                scanner.next();
            }
        }
        System.out.println("Модуль числа: " + abs(x2_1));

        int divX = 0, divY = 0;
        while (true) {
            System.out.print("\nЗадача 2.2 - Введите делимое: ");
            if (scanner.hasNextInt()) {
                divX = scanner.nextInt();
                break;
            } else {
                System.out.println("Введено не целое число.");
                scanner.next();
            }
        }
        while (true) {
            System.out.print("Введите делитель: ");
            if (scanner.hasNextInt()) {
                divY = scanner.nextInt();
                break;
            } else {
                System.out.println("Введено не целое число.");
                scanner.next();
            }
        }
        System.out.println("Результат деления: " + safeDiv(divX, divY));

        int x2_3 = 0;
        while (true) {
            System.out.print("\nЗадача 2.3 - Введите целое число для проверки деления на 3 или 5: ");
            if (scanner.hasNextInt()) {
                x2_3 = scanner.nextInt();
                break;
            } else {
                System.out.println("Введено не целое число.");
                scanner.next();
            }
        }
        System.out.println("Делится на 3 или на 5? -> " + is35(x2_3));

        int decX = 0, decY = 0;
        while (true) {
            System.out.print("\nЗадача 2.4 - Введите первое число для сравнения: ");
            if (scanner.hasNextInt()) {
                decX = scanner.nextInt();
                break;
            } else {
                System.out.println("Введено не целое число.");
                scanner.next();
            }
        }
        while (true) {
            System.out.print("Введите второе число для сравнения: ");
            if (scanner.hasNextInt()) {
                decY = scanner.nextInt();
                break;
            } else {
                System.out.println("Введено не целое число.");
                scanner.next();
            }
        }
        System.out.println("Результат сравнения: " + makeDecision(decX, decY));

        int mX = 0, mY = 0, mZ = 0;
        while (true) {
            System.out.print("\nЗадача 2.5 - Введите первое число: ");
            if (scanner.hasNextInt()) { mX = scanner.nextInt(); break; } 
            else { System.out.println("Введите целое число."); scanner.next(); }
        }
        while (true) {
            System.out.print("Введите второе число: ");
            if (scanner.hasNextInt()) { mY = scanner.nextInt(); break; } 
            else { System.out.println("Введите целое число."); scanner.next(); }
        }
        while (true) {
            System.out.print("Введите третье число: ");
            if (scanner.hasNextInt()) { mZ = scanner.nextInt(); break; } 
            else { System.out.println("Введите целое число."); scanner.next(); }
        }
        System.out.println("Максимальное из трех чисел: " + max3(mX, mY, mZ));
                int x3_1 = 0;
        while (true) {
            System.out.print("\nЗадача 3.1 - Введите целое число: ");
            if (scanner.hasNextInt()) {
                x3_1 = scanner.nextInt();
                break;
            } else {
                System.out.println("Введено не целое число.");
                scanner.next();
            }
        }
        System.out.println("Числа подряд: " + listNums(x3_1));

        int x3_2 = 0;
        while (true) {
            System.out.print("\nЗадача 3.2 - Введите целое число: ");
            if (scanner.hasNextInt()) {
                x3_2 = scanner.nextInt();
                break;
            } else {
                System.out.println("Введено не целое число.");
                scanner.next();
            }
        }
        System.out.println("Числа наоборот: " + reverseListNums(x3_2));

        int x3_3 = 0;
        while (true) {
            System.out.print("\nЗадача 3.3 - Введите целое число: ");
            if (scanner.hasNextInt()) {
                x3_3 = scanner.nextInt();
                break;
            } else {
                System.out.println("Введено не целое число.");
                scanner.next();
            }
        }
        System.out.println("Четные числа: " + chet(x3_3));

        int powX = 0, powY = 0;
        while (true) {
            System.out.print("\nЗадача 3.4 - Введите основание степени: ");
            if (scanner.hasNextInt()) {
                powX = scanner.nextInt();
                break;
            } else {
                System.out.println("Введено не целое число.");
                scanner.next();
            }
        }
        while (true) {
            System.out.print("Введите показатель степени (>=0): ");
            if (scanner.hasNextInt()) {
                powY = scanner.nextInt();
                if (powY >= 0) break;
                else System.out.println("Степень должна быть неотрицательной.");
            } else {
                System.out.println("Введено не целое число.");
                scanner.next();
            }
        }
        System.out.println("Результат возведения в степень: " + pow(powX, powY));

        long x3_5 = 0;
        while (true) {
            System.out.print("\nЗадача 3.5 - Введите число для подсчета длины: ");
            if (scanner.hasNextLong()) {
                x3_5 = scanner.nextLong();
                break;
            } else {
                System.out.println("Введено не целое число.");
                scanner.next();
            }
        }
        System.out.println("Длина числа: " + numLen(x3_5));
        int size = 0;
        while (true) {
            System.out.print("\nЗадача 4 - Введите размер базового массива: ");
            if (scanner.hasNextInt()) {
                size = scanner.nextInt();
                if (size > 0) break;
                System.out.println("Размер массива должен быть больше 0.");
            } else {
                System.out.println("Введено не целое число.");
                scanner.next();
            }
        }
        int[] baseArr = new int[size];
        System.out.println("Введите элементы массива (" + size + " шт.):");
        for (int i = 0; i < size; i = i + 1) {
            while (!scanner.hasNextInt()) {
                System.out.println("Введите целое число:");
                scanner.next();
            }
            baseArr[i] = scanner.nextInt();
        }

        int findX1 = 0;
        System.out.print("Задача 4.1 - Введите число для поиска первого вхождения: ");
        while (!scanner.hasNextInt()) { scanner.next(); }
        findX1 = scanner.nextInt();
        System.out.println("Индекс первого вхождения: " + findFirst(baseArr, findX1));

        int findX2 = 0;
        System.out.print("\nЗадача 4.2 - Введите число для поиска последнего вхождения: ");
        while (!scanner.hasNextInt()) { scanner.next(); }
        findX2 = scanner.nextInt();
        System.out.println("Индекс последнего вхождения: " + findLast(baseArr, findX2));

        System.out.println("\nЗадача 4.3 - Максимальное по модулю из массива: " + maxAbs(baseArr));

        int addX = 0, addPos = 0;
        System.out.print("\nЗадача 4.4 - Введите число для вставки: ");
        while (!scanner.hasNextInt()) { scanner.next(); }
        addX = scanner.nextInt();
        while (true) {
            System.out.print("Введите позицию для вставки (от 0 до " + baseArr.length + "): ");
            if (scanner.hasNextInt()) {
                addPos = scanner.nextInt();
                if (addPos >= 0 && addPos <= baseArr.length) break;
            } else { scanner.next(); }
        }
        System.out.println("Массив после вставки числа: " + Arrays.toString(add(baseArr, addX, addPos)));

        int insSize = 0;
        while (true) {
            System.out.print("\nЗадача 4.5 - Введите размер вставляемого массива: ");
            if (scanner.hasNextInt()) {
                insSize = scanner.nextInt();
                if (insSize >= 0) break;
            } else { scanner.next(); }
        }
        int[] insArr = new int[insSize];
        System.out.println("Введите элементы вставляемого массива (" + insSize + " шт.):");
        for (int i = 0; i < insSize; i++) {
            while (!scanner.hasNextInt()) { scanner.next(); }
            insArr[i] = scanner.nextInt();
        }
        int insPos = 0;
        while (true) {
            System.out.print("Введите позицию для вставки массива (от 0 до " + baseArr.length + "): ");
            if (scanner.hasNextInt()) {
                insPos = scanner.nextInt();
                if (insPos >= 0 && insPos <= baseArr.length) break;
            } else { scanner.next(); }
        }
        System.out.println("Массив после вставки массива: " + Arrays.toString(add(baseArr, insArr, insPos)));

        scanner.close();
    }

    public static double fraction(double x) {
        return x - (int)x;
    }

    public static int sumLastNums(int x) {
        int absX = Math.abs(x); 
        return (absX % 10) + ((absX / 10) % 10);
    }

    public static int charToNum(char x) {
        return x - '0';
    }

    public static boolean isPositive(int x) {
        return x > 0;
    }

    public static boolean is2Digits(int x) {
        int absX = Math.abs(x);
        return absX >= 10 && absX <= 99;
    }




    public static int abs(int x) {
        if (x < 0) {
            return -x; 
        } else {
            return x;  
        }
    }


    public static double safeDiv(int x, int y) {
        if (y == 0) return 0;
        return (double) x / y;
    }

    public static boolean is35(int x) {
        return (x % 3 == 0) ^ (x % 5 == 0);
    }

    public static String makeDecision(int x, int y) {
        if (x > y) return x + " > " + y;
        else if (x < y) return x + " < " + y;
        else return x + " == " + y;
    }

    public static int max3(int x, int y, int z) {
        int max = x;
        if (y > max) max = y;
        if (z > max) max = z;
        return max;
    }

        public static String listNums(int x) {
        String res = "";
        for (int i = 0; i <= x; i = i + 1) {
            res += i + " ";
        }
        return res.trim();
    }

    public static String reverseListNums(int x) {
        String res = "";
        for (int i = x; i >= 0; i = i - 1) {
            res += i + " ";
        }
        return res.trim();
    }

    public static String chet(int x) {
        String res = "";
        for (int i = 0; i <= x; i = i + 2) {
            res += i + " ";
        }
        return res.trim();
    }

    public static int pow(int x, int y) {
        int res = 1;
        for (int i = 0; i < y; i = i + 1) {
            res = res * x;
        }
        return res;
    }

    public static int numLen(long x) {
        long absX = Math.abs(x);
        if (absX == 0) return 1;
        int count = 0;
        while (absX > 0) {
            count = count + 1;
            absX /= 10;
        }
        return count;
    }
        public static int findFirst(int[] arr, int x) {
        for (int i = 0; i < arr.length; i = i + 1) {
            if (arr[i] == x) return i;
        }
        return -1;
    }

    public static int findLast(int[] arr, int x) {
        for (int i = arr.length - 1; i >= 0; i = i - 1) {
            if (arr[i] == x) return i;
        }
        return -1;
    }

    public static int maxAbs(int[] arr) {
        int maxElement = arr[0];
        for (int i = 1; i < arr.length; i = i + 1) {
            if (Math.abs(arr[i]) > Math.abs(maxElement)) {
                maxElement = arr[i];
            }
        }
        return maxElement;
    }

    public static int[] add(int[] arr, int x, int pos) {
        int[] result = new int[arr.length + 1];
        for (int i = 0; i < pos; i = i + 1) {
            result[i] = arr[i];
        }
        result[pos] = x;
        for (int i = pos; i < arr.length; i = i + 1) {
            result[i + 1] = arr[i];
        }
        return result;
    }

    public static int[] add(int[] arr, int[] ins, int pos) {
        int[] result = new int[arr.length + ins.length];
        for (int i = 0; i < pos; i++) {
            result[i] = arr[i];
        }
        for (int i = 0; i < ins.length; i++) {
            result[pos + i] = ins[i];
        }
        for (int i = pos; i < arr.length; i++) {
            result[ins.length + i] = arr[i];
        }
        return result;
    }

}
