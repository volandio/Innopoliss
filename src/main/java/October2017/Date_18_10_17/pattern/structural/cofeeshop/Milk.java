package October2017.Date_18_10_17.pattern.structural.cofeeshop;

public class Milk extends CofeeDecorator implements CofeeIngridient {
    public Milk(CofeeIngridient innerIngridient) {
        super(innerIngridient);
    }

    @Override
    public void showIngridient() {
        super.showIngridient();
        System.out.println("Milk");
    }
}
