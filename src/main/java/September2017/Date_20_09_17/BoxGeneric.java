package September2017.Date_20_09_17;

public class BoxGeneric<T extends Comparable<T>> {
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void print() {
        System.out.println(value);
    }

    public int compareTo(T obj) {
        return this.value.compareTo(obj);
    }
}
