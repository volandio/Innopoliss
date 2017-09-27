package Date_22_09_17;

public class deadLock {
    public static void main(String[] args) throws InterruptedException {
        final Object resource1 = "resource1";
        final Object resource2 = "resource2";
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource1) {
                    System.out.println("Thread 1: locked resource 1");
                    synchronized (resource2) {
                        System.out.println("Thread 1: locked resource 2");
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource2) {
                    System.out.println("Thread 2: locked resource 2");
                    synchronized (resource1) {
                        System.out.println("Thread 2: locked resource 1");
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }
}

