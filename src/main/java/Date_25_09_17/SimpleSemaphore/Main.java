package Date_25_09_17.SimpleSemaphore;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SimpleSemaphore semaphore = new SimpleSemaphore();
        new Thread(new SignalSender(semaphore)).start();
        Thread.currentThread().sleep(2000);
        new Thread(new SignalReceiver(semaphore)).start();
    }

    static class SignalSender implements Runnable {
        private final SimpleSemaphore semaphore;

        public SignalSender(SimpleSemaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            System.out.println("[SignalSender] run");
            while (true) {
                try {
                    doSomeWork();
                    semaphore.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void doSomeWork() throws InterruptedException {
            System.out.println("[SignalSender] do some work");
            Thread.sleep(500);
        }
    }

    static class SignalReceiver implements Runnable {
        private final SimpleSemaphore semaphore;

        public SignalReceiver(SimpleSemaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            System.out.println("[SignalReceiver] run");
            while (true) {
                try {
                    semaphore.release();
                    doSomeWork();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void doSomeWork() throws InterruptedException {
            System.out.println("[SignalReceiver] do some work");
            Thread.sleep(700);
        }
    }
}
