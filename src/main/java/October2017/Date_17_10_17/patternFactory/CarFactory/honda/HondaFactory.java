package October2017.Date_17_10_17.patternFactory.CarFactory.honda;


import October2017.Date_17_10_17.patternFactory.CarFactory.*;

public class HondaFactory implements MotoFactory {
    @Override
    public BikeMoto createBike() {
        return new HondaBike();
    }

    @Override
    public SportMoto createSport() {
        return new HondaSport();
    }

    @Override
    public EnduroMoto createEnduro() {
        return new HondaEnduro();
    }

    @Override
    public QuatroMoto createQuatro() {
        return new HondaQuad();
    }
}
