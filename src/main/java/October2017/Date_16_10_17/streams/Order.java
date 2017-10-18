package October2017.Date_16_10_17.streams;

public class Order {
    String name;
    Integer summ;
    Double number;

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", summ=" + summ +
                ", number=" + number +
                '}';
    }

    public Order(String name, Integer summ, Double number) {
        this.name = name;
        this.summ = summ;
        this.number = number;
    }
}
