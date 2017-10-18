package October2017.Date_18_10_17.pattern.structural.cofeeshop;

public class Main {
    public static void main(String[] args) {
        Cofee cofee = new Cofee(new Milk(new Sugar(new Cinnamon(null))));
        cofee.showIngridient();
    }
}
