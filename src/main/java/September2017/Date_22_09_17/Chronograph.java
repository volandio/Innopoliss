package September2017.Date_22_09_17;

public class Chronograph {
    static volatile int counter = 0;
    static Object monitor = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println("Текущее время: " + counter + " секунд");
                        counter += 1;
                        Thread.currentThread().sleep(1000);

                        synchronized (monitor){
                            monitor.notifyAll();
                        }
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
                    synchronized (monitor){
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }
}
