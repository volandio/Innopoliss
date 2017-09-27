package Date_20_09_17;

public class Pair<T extends Number> {
    private T field1;
    private T field2;


    public Pair(T field1, T field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    public Number summ() {
        return field1.doubleValue() + field2.doubleValue();
    }

    public Number minus() {
        return field1.doubleValue() - field2.doubleValue();
    }

    public Number multiply() {
        return field1.doubleValue() * field2.doubleValue();
    }

    public Number divide() {
        return field1.doubleValue() / field2.doubleValue();
    }

    public static void main(String[] args) {
        Double d = 3.0;
        Long l = 6L;
        Pair pair = new Pair(d, l);
        System.out.println(pair.summ());
        System.out.println(pair.divide());
    }
}
