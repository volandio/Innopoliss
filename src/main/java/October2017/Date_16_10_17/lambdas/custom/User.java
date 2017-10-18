package October2017.Date_16_10_17.lambdas.custom;

public class User {
    Worker workMethod;

    public User() {
    }

    public User(Worker worker) {
        workMethod = worker;
    }

    public void process(){
        if(workMethod != null)
            workMethod.work();
        else {
            workMethod = () -> {};
            workMethod.workReserved();
        }
    }
}
