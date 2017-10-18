package October2017.Date_17_10_17.patternFactory.Cars;

public class CarFactory {
    public static AbstractCar createCar(String carName){
        switch (carName){
            case "Lada": return new Lada();
            default: return new Mercedes();
        }
    }
}
