package October2017.Date_03_10_17;

public class Printer {
    public static void print() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Hi");
    }
}
