package October2017.Date_16_10_17.lambdas.custom;

public class CustomFuncInterfs {
    public static void main(String[] args) {
        User userGood =
                new User(()->{
                    System.out.println("I work good");
                });

        User userLazy =
                new User(()->{
                    System.out.println("I work lazy");
                });

        userGood.process();
        userLazy.process();

        User userEmpty = new User();
        userEmpty.process();
    }
}
