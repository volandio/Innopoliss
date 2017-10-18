package October2017.Date_18_10_17.pattern.structural.cofeeshop;

public class Cofee extends CofeeDecorator {
    public Cofee(CofeeIngridient innerIngridient) {
        super(innerIngridient);
    }

    @Override
    public void showIngridient() {
        System.out.println("Cofee");
        super.showIngridient();
    }
}
