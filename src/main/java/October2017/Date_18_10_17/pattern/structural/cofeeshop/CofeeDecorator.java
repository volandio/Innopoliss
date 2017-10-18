package October2017.Date_18_10_17.pattern.structural.cofeeshop;

public abstract class CofeeDecorator implements CofeeIngridient{
    protected CofeeIngridient innerIngridient;

    public CofeeDecorator(CofeeIngridient innerIngridient) {
        this.innerIngridient = innerIngridient;
    }

    @Override
    public void showIngridient(){
        if (innerIngridient != null) {
            innerIngridient.showIngridient();
        }
    }
}
