package October2017.Date_03_10_17;

public class Main {
    public static void main(String[] args) {
        Thread updater = new Thread(() -> {
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            ClassLoader loader = Printer.class.getClassLoader();
            try {
                loader.loadClass("October2017.Date_03_10_17.Printer");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        updater.start();

        while (true) {
            Printer.print();
        }
    }
}
