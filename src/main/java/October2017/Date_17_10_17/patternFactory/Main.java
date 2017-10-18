package October2017.Date_17_10_17.patternFactory;


import October2017.Date_17_10_17.patternFactory.Cars.AbstractCar;
import October2017.Date_17_10_17.patternFactory.Cars.CarFactory;

public class Main {

    public static void main(String[] args) {

        AbstractCar[] cars = {CarFactory.createCar("Lada"),
                CarFactory.createCar("")};
        for (AbstractCar car : cars){
            car.Crash(null);
        }

    }

}
