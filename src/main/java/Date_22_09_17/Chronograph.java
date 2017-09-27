package Date_22_09_17;

public class Chronograph {
    static volatile int counter = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println("Текущее время: " + counter + " секунд");
                        counter += 1;
                        Thread.currentThread().sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("Прошло времени: " + counter + " секунд");
                    try {
                        Thread.currentThread().sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }
}
