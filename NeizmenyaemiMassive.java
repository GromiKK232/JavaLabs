package ru.bochkarev.data;
public class NeizmenyaemiMassive {
    private final int[] array;

    public NeizmenyaemiMassive(int[] array) {
        if (array == null) {
            this.array = new int[0];
        } else {
            this.array = new int[array.length];
            System.arraycopy(array, 0, this.array, 0, array.length);
        }
    }

    public int getValue(int index) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException("Индекс " + index + " вышел за пределы");
        }
        return array[index];
    }

    public void setValue(int index, int newValue) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException("Индекс " + index + " вышел за пределы");
        }
        array[index] = newValue;
    }

    public boolean isEmpty() {
        return array.length == 0;
    }

    public int getSize() {
        return array.length;
    }

    public int[] toStandardArray() {
        int[] copy = new int[array.length];
        System.arraycopy(array, 0, copy, 0, array.length);
        return copy;
    }

    @Override
    public String toString() {
        if (array.length == 0) {
            return "[]";
        }
        String result = "[";
        for (int i = 0; i < array.length; i++) {
            result += array[i];
            if (i < array.length - 1) {
                result += ", ";
            }
        }
        result += "]";
        return result;
    }
}
