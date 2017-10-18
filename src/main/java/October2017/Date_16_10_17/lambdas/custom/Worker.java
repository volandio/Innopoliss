package October2017.Date_16_10_17.lambdas.custom;

@FunctionalInterface
public interface Worker {
    abstract void work();

    default void workReserved(){
        System.out.println("Work some work");
    }
}
