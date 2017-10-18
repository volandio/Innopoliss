package October2017.Date_17_10_17.patternFactory.CarFactory.ural;


import October2017.Date_17_10_17.patternFactory.CarFactory.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class UralFactory implements MotoFactory {
    @Override
    public BikeMoto createBike() {
        return new UralBike();
    }

    @Override
    public SportMoto createSport() {
        return new UralSport();
    }

    @Override
    public EnduroMoto createEnduro() {
        return new UralEnduro();
    }

    @Override
    public QuatroMoto createQuatro()  {
        throw new NotImplementedException();
    }
}
