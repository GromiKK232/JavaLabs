public class Storage<T> {
    private final T item;

    public Storage(T item) {
        this.item = item;
    }

    public T getValue(T alternative) {
        if (item == null) {
            return alternative;
        }
        return item;
    }

    @Override
    public String toString() {
        return "Коробка с: " + item;
    }
}
