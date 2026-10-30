import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class lab4 {
    public static void main(String[] args) {
        
        System.out.println("ЗАДАНИЕ 1(2): ХРАНИЛИЩЕ ");
        // null, 0 - 0
        Storage<Integer> numStorage1 = new Storage<>(null);
        printStorageValue(numStorage1, 0);
        // 99, -1 - 99
        Storage<Integer> numStorage2 = new Storage<>(99);
        printStorageValue(numStorage2, -1);
        // null, default - default
        Storage<String> strStorage1 = new Storage<>(null);
        printStorageValue(strStorage1, "default");
        // hello, hello world - hello
        Storage<String> strStorage2 = new Storage<>("hello");
        printStorageValue(strStorage2, "hello world");

        System.out.println();

        System.out.println("ЗАДАНИЕ 1(5): ВЫВОД ТРЕХМЕРНОЙ ЛИНИИ ");
        Point3D p1 = new Point3D(1, 2, 3);
        Point3D p2 = new Point3D(4, 5, 6);
        Line<Point3D> 
        line3DOriginal = new Line<>(p1, p2);
        System.out.println(line3DOriginal);
        System.out.println();


        System.out.println("ЗАДАНИЕ 2: СДВИГ ЛИНИИ ");
        
        Line<Point2D> line2D = new Line<>(new Point2D(5, 3), new Point2D(10, 10));
        System.out.println("2D до сдвига: " + line2D);
        shiftLineX10(line2D);
        System.out.println("2D после сдвига: " + line2D);
        System.out.println();

        Line<Point3D> line3DShift = new Line<>(new Point3D(-7, 2, 4), new Point3D(4, 5, 6));
        System.out.println("3D до сдвига: " + line3DShift);
        shiftLineX10(line3DShift);
        System.out.println("3D после сдвига: " + line3DShift);
        System.out.println();

        System.out.println("ЗАДАНИЕ 3.1: ТРАНСФОРМАЦИЯ ");

        List<String> strings31 = new ArrayList<>();
        strings31.add("qwerty"); //6
        strings31.add("asdfg"); //5
        strings31.add("zx"); //2
        List<Integer> 
        lengths = transform(strings31, new StringLengthTransformer("Длина строки"));
        System.out.println("1. Длины строк: " + lengths);

        List<Integer> numbers31 = new ArrayList<>();
        numbers31.add(1); 
        numbers31.add(-3); 
        numbers31.add(7);
        List<Integer> absoluteNumbers = transform(numbers31, new AbsoluteValueTransformer("Модуль числа"));
        System.out.println("2. Положительные числа: " + absoluteNumbers);

        List<int[]> arrays31 = new ArrayList<>();
        arrays31.add(new int[]{1, 5, 3});
        arrays31.add(new int[]{-10, -2, -5});
        arrays31.add(new int[]{7, 7, 7});
        List<Integer> maxValues = transform(arrays31, new ArrayMaxTransformer("Поиск максимума"));
        System.out.println("3. Максимумы массивов: " + maxValues);
        System.out.println();


        System.out.println("ЗАДАНИЕ 3.2: ФИЛЬТРАЦИЯ");

        List<String> strings32 = new ArrayList<>();
        strings32.add("qwerty"); 
        strings32.add("asdfg"); 
        strings32.add("zx");
        List<String> filteredStrings = filter(strings32, new StringLengthCondition("Длина >= 3"));
        System.out.println("1. Отфильтрованные строки: " + filteredStrings);

        List<Integer> numbers32 = new ArrayList<>();
        numbers32.add(1); 
        numbers32.add(-3); 
        numbers32.add(7);
        List<Integer> filteredNumbers = filter(numbers32, new NegativeNumberCondition("Числа <= 0"));
        System.out.println("2. Отфильтрованные числа: " + filteredNumbers);

        List<int[]> 
        arrays32 = new ArrayList<>();
        arrays32.add(new int[]{-1, -5, -3});
        arrays32.add(new int[]{1, -2, -5});
        List<int[]> filteredArrays = filter(arrays32, new NoPositiveElementsCondition("Без положительных"));
        System.out.print("3. Отфильтрованные массивы: [");
        for (int i = 0; i < filteredArrays.size(); i++) {
            System.out.print(Arrays.toString(filteredArrays.get(i)));
            if (i < filteredArrays.size() - 1) System.out.print(", ");
        }
        System.out.println("]");
        System.out.println();


        System.out.println("ЗАДАНИЕ 3.3: СОКРАЩЕНИЕ");

        List<String> strings33 = List.of("qwerty", "asdfg", "zx");
        String resultStr = reduce(strings33, new StringConcatCombiner("Склеивание"), "");
        System.out.println("1. Склеенная строка: " + resultStr);

        List<Integer> numbers33 = List.of(1, -3, 7);
        Integer resultSum = reduce(numbers33, new IntegerSumCombiner("Сумма"), 0);
        System.out.println("2. Сумма чисел: " + resultSum);

        List<List<Integer>> listOfLists = List.of(List.of(1, 2, 3), List.of(4, 5), List.of(6, 7, 8, 9));
        Transformer<List<Integer>, Integer> listSizeTransformer = new Transformer<>() {
            private final String desc = "Размер списка";

            @Override 
            public Integer apply(List<Integer> value) { 
                return value.size(); 
            }

            @Override public String toString() {
                 return desc; 
            }
        };
        List<Integer> sizes = transform(listOfLists, listSizeTransformer);
        Integer totalCount = reduce(sizes, new IntegerSumCombiner("Сумма размеров"), 0);
        System.out.println("3. Количество элементов в списке списков: " + totalCount);

        List<Integer> emptyList = new ArrayList<>();
        Integer emptyResult = reduce(emptyList, new IntegerSumCombiner("Сумма"), 0);
        System.out.println("4. Тест пустого списка (базовый элемент): " + emptyResult);
        System.out.println();


        System.out.println("ЗАДАНИЕ 3.4: КОЛЛЕКЦИОНИРОВАНИЕ");

        List<Integer> numbers34 = List.of(1, -3, 7);
        ResultFactory<List<List<Integer>>> listFactory = new ResultFactory<>() {
            @Override public List<List<Integer>> create() { 
                List<List<Integer>> res = new ArrayList<>();
                res.add(new ArrayList<>()); res.add(new ArrayList<>());
                return res; 
            }
        };
        List<List<Integer>> splitResult = collectValues(numbers34, listFactory, new NumberSplitWriter("Разделение по знаку"));
        System.out.println("1. Разделенные числа: " + splitResult);

        List<String> strings34 = List.of("qwerty", "asdfg", "zx", "qw");
        ResultFactory<Map<Integer, List<String>>> mapFactory = java.util.HashMap::new;
        Map<Integer, List<String>> mapResult = collectValues(strings34, mapFactory, new StringGroupWriter("Группировка по длине"));
        System.out.println("2. Группировка строк по длине: " + mapResult);

        List<String> duplicateStrings = List.of("qwerty", "asdfg", "qwerty", "zx", "asdfg");
        ResultFactory<Set<String>> setFactory = java.util.HashSet::new;
        Set<String> setResult = collectValues(duplicateStrings, setFactory, new StringSetWriter("Уникальные строки"));
        System.out.println("3. Множество уникальных строк: " + setResult);
    }

    public static <V> void printStorageValue(Storage<V> storage, V alternative) {
        V value = storage.getValue(alternative);
        System.out.println("Результат: " + value);
    }

    public static void shiftLineX10(Line<? extends Point2D> line) {
        line.getStart().shiftX(10);
    }

    public static <T, P> List<P> transform(List<T> source, Transformer<T, P> transformer) {
        List<P> result = new ArrayList<>();
        for (T item : source) { result.add(transformer.apply(item)); }
        return result;
    }

    public static <T> List<T> filter(List<T> source, Condition<T> condition) {
        List<T> result = new ArrayList<>();
        for (T item : source) { if (condition.test(item)) result.add(item); }
        return result;
    }

    public static <T> T reduce(List<T> source, Combiner<T> combiner, T identity) {
        if (source == null || source.isEmpty()) return identity;
        T result = identity;
        for (T item : source) { result = combiner.combine(result, item); }
        return result;
    }

    public static <T, R> R collectValues(List<T> source, ResultFactory<R> factory, ResultWriter<R, T> writer) {
        R resultContainer = factory.create();
        for (T item : source) { writer.add(resultContainer, item); }
        return resultContainer;
    }
}

